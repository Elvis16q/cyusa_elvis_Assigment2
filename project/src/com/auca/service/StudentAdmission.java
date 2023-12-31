package com.auca.service;

import java.io.*;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig
public class StudentAdmission extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		
		   Collection<Part> parts = request.getParts();

	        for (Part part : parts) {

	            if (part.getContentType() != null) {
	 
	                String fileName = getFileName(part);
	                
	                
	                if (fileName != null && (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".pdf"))) {
	                    String uploadDirectory = "E:\\";
	                    
	                    
	                    File uploadDir = new File(uploadDirectory);
	                    if (!uploadDir.exists()) {
	                        uploadDir.mkdirs();
	                    }
	                    
	                    part.write(uploadDirectory + File.separator + fileName);
	                    
	                    
	                    PrintWriter out = response.getWriter();
	                    out.println("Uploaded Successfully");
	                } else {
	                    
	                	PrintWriter out = response.getWriter();
	                    out.println("Uploaded Unsuccessfully");
	                }
	            }
	        }
	    }
	    
	    private String getFileName(Part part) {
	        String contentDisposition = part.getHeader("content-disposition");
	        String[] tokens = contentDisposition.split(";");
	        for (String token : tokens) {
	            if (token.trim().startsWith("filename")) {
	                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
	            }
	        }
	        return null;
		
		
	}

}
