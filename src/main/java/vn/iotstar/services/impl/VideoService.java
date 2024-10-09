package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.Dao.IVideoDao;
import vn.iotstar.Dao.impl.VideoDaoImpl;
import vn.iotstar.entity.Video;
import vn.iotstar.services.IVideoService;

public class VideoService implements IVideoService{

	IVideoDao vi = new VideoDaoImpl();
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return vi.count();
	}

	@Override
	public List<Video> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		return vi.findAll();
	}

	@Override
	public List<Video> findByVideoname(String videoname) {
		// TODO Auto-generated method stub
		return vi.findByVideoname(videoname);
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return vi.findAll();
	}

	@Override
	public Video findById(String videoid) {
		// TODO Auto-generated method stub
		return vi.findById(videoid);
	}

	@Override
	public void delete(String videoid) throws Exception {
		// TODO Auto-generated method stub
		vi.delete(videoid);
		
	}

	@Override
	public void update(Video video) {
		// TODO Auto-generated method stub
		vi.update(video);
	}

	@Override
	public void insert(Video video) {
		// TODO Auto-generated method stub
		vi.insert(video);
	}
	
}
