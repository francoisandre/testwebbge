package testweb.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			InputStream is = new FileInputStream(new File("C:/Users/fandre5/Downloads/academy-tetris-solution.zip"));
			OutputStream os = resp.getOutputStream();

			resp.setContentType("application/zip");
			resp.setHeader("Content-Disposition", "attachement;filename=toto.zip");

			int count;

			byte buf[] = new byte[4096];
			while ((count = is.read(buf)) > -1) {
				os.write(buf, 0, count);
			}

			is.close();
			os.close();
		} catch (Exception e) {
			resp.setStatus(500);
		}

	}

}
