package com.zesar.webservice.download;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class FileDownloadService {

	private static final String textFile = "D:\\akansha.txt";
	private static final String imgFile = "D:\\java\\download.jfif";
	private static final String pdfFile = "D:\\Akansha\\JavaAssignment\\CertificateOfCompletion.pdf";

	@GET
	@Path("/text")
	@Produces("text/plain")
	public Response getTextFile() {
		File file = new File(textFile);
		ResponseBuilder builder = Response.ok(file);
		builder.header("Content-Disposition", "attachment;filename=hello.txt");
		return builder.build();

	}

	@GET
	@Path("/img")
	@Produces("image/jfif")
	public Response getimgFile() {
		File file = new File(imgFile);
		ResponseBuilder builder = Response.ok(file);
		builder.header("Content-Disposition", "attachment;filename=download.jpg");
		return builder.build();

	}

	@GET
	@Path("/pdf")
	@Produces("application/pdf")
	public Response getpdfFile() {
		File file = new File(pdfFile);
		ResponseBuilder builder = Response.ok(file);
		builder.header("Content-Disposition", "attachment;filename=certificate.pdf");
		return builder.build();

	}
}
