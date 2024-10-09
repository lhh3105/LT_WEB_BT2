package vn.iotstar.Dao;
import java.util.List;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Video;

public interface IVideoDao {
	 public int count();



	 public List<Video> findAll(int page, int pagesize);



	 public List<Video> findByVideoname(String videoname);



	 public List<Video> findAll();



	 public Video findById(String videoid);



	 public void delete(String videoid) throws Exception;



	 public void update(Video video);



	 public void insert(Video video);


}
