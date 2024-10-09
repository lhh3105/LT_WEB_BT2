package vn.iotstar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Video;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.IVideoService;
import vn.iotstar.services.impl.CategoryService;
import vn.iotstar.services.impl.VideoService;
import vn.iotstar.utils.Constant;



@MultipartConfig(fileSizeThreshold = 1024 * 1024,

maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/edit", "/admin/video/update",

"/admin/video/insert", "/admin/video/add", "/admin/video/delete" })
public class VideoController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	IVideoService videoService =  new VideoService();
	ICategoryService cateService = new CategoryService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();

		if (url.contains("videos")) {

			List<Video> list = videoService.findAll();
			List<Category> listcate = cateService.findAll();

			req.setAttribute("listvideo", list);
			req.setAttribute("listcate", listcate);

			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);

		} else if (url.contains("/admin/video/edit")) {

			String id = req.getParameter("id");

			Video video = videoService.findById(id);
			
			List<Category> listcate = cateService.findAll();
			req.setAttribute("listcate", listcate);
			

			req.setAttribute("video", video);

			req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);

		}

		else if (url.contains("/admin/video/add")) {
			List<Category> listcate = cateService.findAll();
			req.setAttribute("listcate", listcate);

			req.getRequestDispatcher("/views/admin/video-add.jsp").forward(req, resp);

		} else if (url.contains("/admin/video/delete")) {

			String id = (req.getParameter("id"));

			try {

				videoService.delete(id);

			} catch (Exception e) {

				e.printStackTrace();

			}

			resp.sendRedirect(req.getContextPath() + "/admin/videos");

		}

	}

	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();

		if (url.contains("/admin/video/update")) {

			String videoid = req.getParameter("videoid");

			String videoname = req.getParameter("videoname");

			int status = Integer.parseInt(req.getParameter("status"));
			
			
			int cateid = Integer.parseInt(req.getParameter("mycate"));
			Category cate = cateService.findById(cateid);
			

			Video video = new Video();

			video.setVideoId(videoid);

			video.setTitle(videoname);
			
			video.setActive(status);
			
			video.setCategory(cate);

			// lưu hình cũ

			Video cateold = videoService.findById(videoid);

			String fileold = cateold.getImages();

			// xử lý images

			String fname = "";

			String uploadPath = Constant.DIR;

			File uploadDir = new File(uploadPath);

			if (!uploadDir.exists()) {

				uploadDir.mkdir();

			}

			try {

				Part part = req.getPart("images");

				if (part.getSize() > 0) {

					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

					// đổi tên file

					int index = filename.lastIndexOf(".");

					String ext = filename.substring(index + 1);

					fname = System.currentTimeMillis() + "." + ext;

					// up load file

					part.write(uploadPath + "/" + fname);

					// ghi tên file vào data

					video.setImages(fname);

				} else {

					video.setImages(fileold);

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

			videoService.update(video);

			resp.sendRedirect(req.getContextPath() + "/admin/videos");

		} else if (url.contains("/admin/video/insert")) {

			Video video = new Video();
			String videoid = req.getParameter("videoid");
			String videoname = req.getParameter("videoname");
			int status = Integer.parseInt(req.getParameter("status"));
			
			int cateid = Integer.parseInt(req.getParameter("mycate"));
			Category cate = cateService.findById(cateid);
			video.setCategory(cate);
			
			video.setVideoId(videoid);
			video.setTitle(videoname);

			video.setActive(status);
			
			

			String fname = "";

			String uploadPath = Constant.DIR;

			File uploadDir = new File(uploadPath);

			if (!uploadDir.exists()) {

				uploadDir.mkdir();

			}

			try {

				Part part = req.getPart("images");

				if (part.getSize() > 0) {

					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

					// đổi tên file

					int index = filename.lastIndexOf(".");

					String ext = filename.substring(index + 1);

					fname = System.currentTimeMillis() + "." + ext;

					// up load file

					part.write(uploadPath + "/" + fname);

					// ghi tên file vào data

					video.setImages(fname);

				} else {

					video.setImages("avata.png");

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

			videoService.insert(video);

			resp.sendRedirect(req.getContextPath() + "/admin/videos");

		}
	}

}
