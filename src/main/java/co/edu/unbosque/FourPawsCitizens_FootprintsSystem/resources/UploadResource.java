package co.edu.unbosque.FourPawsCitizens_FootprintsSystem.resources;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.servlet.ServletContext;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Path("/upload")
public class UploadResource {

    private final String UPLOAD_DIRECTORY = "/image/";

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@Context ServletContext servletContext, MultipartFormDataInput input) {

        String fileName = "";

        // Getting the file from form input
        Map<String, List<InputPart>> formParts = input.getFormDataMap();
        List<InputPart> inputParts = formParts.get("file");

        for (InputPart inputPart : inputParts) {

            try {

                // Retrieving headers and reading the Content-Disposition header to file name
                MultivaluedMap<String, String> headers = inputPart.getHeaders();
                fileName = parseFileName(headers);

                // Handling the body of the part with an InputStream
                InputStream istream = inputPart.getBody(InputStream.class,null);

                saveFile(istream, fileName, servletContext);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
//C:\Users\jvtp0\git\FourPawsCitizens-FootprintsSystem\target\FourPawsCitizens-FootprintsSystem-1.0-SNAPSHOT\image

        return Response.status(200).entity(fileName).build();
    }

    // Parse Content-Disposition header to get the file name
    private String parseFileName(MultivaluedMap<String, String> headers) {

        String[] contentDispositionHeader = headers.getFirst("Content-Disposition").split(";");

        for (String name : contentDispositionHeader) {
            if ((name.trim().startsWith("filename"))) {
                String[] tmp = name.split("=");
                String fileName = tmp[1].trim().replaceAll("\"","");
                fileName=getNameAlfaNumeric(fileName);
                return fileName;
            }
        }
        return "unknown";
    }

    // Save uploaded file to a defined location on the server
    private void saveFile(InputStream uploadedInputStream, String fileName, ServletContext servletContext) {

        int read = 0;
        byte[] bytes = new byte[1024];

        try {

            // Complementing servlet path with the relative path on the server
            String uploadPath = servletContext.getRealPath("") + UPLOAD_DIRECTORY;

            // Creating the upload folder, if not exist
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) uploadDir.mkdir();

            // Persisting the file by output stream
            OutputStream outpuStream = new FileOutputStream(uploadPath + fileName);
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                outpuStream.write(bytes, 0, read);
            }
            outpuStream.flush();
            outpuStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     *This method make the name alfanumeric of the image with 28 characters in upper and lower case
     *
     * @param fileName, it's the file name where will be the image
     * @return namePhoto.toString() + fileName.substring(fileName.lastIndexOf(".")), it's the new name of the image with type of file
     **/

    private String getNameAlfaNumeric(String fileName) {

        byte[] bytearray = new byte[256];
        String chain;
        StringBuffer namePhoto;
        String theAlphaNumericLower;
        String theAlphaNumericUpper;
        int i = 28;

        new Random().nextBytes(bytearray);
        chain = new String(bytearray, StandardCharsets.UTF_8);

        namePhoto = new StringBuffer();

        theAlphaNumericLower = chain.replaceAll("[^A-Z0-9]", "").toLowerCase();
        theAlphaNumericUpper = chain.replaceAll("[^A-Z0-9]", "");

        for (int m = 0; m < theAlphaNumericLower.length(); m++) {

            if (Character.isLetter(theAlphaNumericLower.charAt(m)) && (i > 0)
                    || Character.isDigit(theAlphaNumericLower.charAt(m)) && (i > 0)
                    || Character.isLetter(theAlphaNumericUpper.charAt(m)) && (i > 0)
                    || Character.isDigit(theAlphaNumericUpper.charAt(m)) && (i > 0)) {
                if (i % 2 == 0) {
                    namePhoto.append(theAlphaNumericUpper.charAt(m));
                } else {
                    namePhoto.append(theAlphaNumericLower.charAt(m));
                }
                i--;
            }
        }

        return namePhoto.toString() + fileName.substring(fileName.lastIndexOf("."));
    }


}
