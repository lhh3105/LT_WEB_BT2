package vn.iotstar.Dao.impl;

import vn.iotstar.Dao.ICategoryDao;
import vn.iotstar.Dao.IVideoDao;

import java.util.List;
import jakarta.persistence.*;
import vn.iotstar.entity.*;



import vn.iotstar.configs.JPAConfig;
import vn.iotstar.entity.Category;

public class VideoDaoImpl implements IVideoDao {
	
		 @Override
		 public void insert(Video video) {


			 EntityManager enma = JPAConfig.getEntityManager();
			 EntityTransaction trans = enma.getTransaction();

			 try {
				 trans.begin();
				 //gọi phuong thức để insert, update, delete
				 enma.persist(video);
				 trans.commit();


			 } catch (Exception e) {
				 e.printStackTrace();
				 trans.rollback();
				 throw e;

		 } finally {
			 	enma.close();

		 }


		}

		 @Override
		 public void update(Video video) {
		 EntityManager enma = JPAConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		 try {
			 trans.begin();
			 //gọi phuong thức để insert, update, delete
			 enma.merge(video);
			 trans.commit();
		 } catch (Exception e) {
			 e.printStackTrace();
			 trans.rollback();
			 throw e;
		 } finally {
			 enma.close();

		 }


		}


		 @Override
		 public void delete(String videoid) throws Exception {
			 EntityManager enma = JPAConfig.getEntityManager();
			 EntityTransaction trans = enma.getTransaction();

			 try {
				 trans.begin();
				 //gọi phuong thức để insert, update, delete
				 Video video = enma.find(Video.class,videoid);
			 	 if(video != null) {
			 		 enma.remove(video);
			 	 }else {
			 		 throw new Exception("Không tìm thấy");
			 	 }

			 	 trans.commit();

			 } catch (Exception e) {
				 e.printStackTrace();
				 trans.rollback();
				 throw e;
			 } finally {
				 enma.close();


			 }


		 }


		 @Override
		 public Video findById(String videoid) {


		 EntityManager enma = JPAConfig.getEntityManager();


		 Video video = enma.find(Video.class,videoid);


		 return video;


		 }


		 @Override


		 public List<Video> findAll() {


		 EntityManager enma = JPAConfig.getEntityManager();


		 TypedQuery<Video> query= enma.createNamedQuery("Video.findAll", Video.class);


		 return query.getResultList();


		 }


		 @Override


		 public List<Video> findByVideoname(String videoname) {


		 EntityManager enma = JPAConfig.getEntityManager();


		 String jpql = "SELECT c FROM Video c WHERE c.videoName like :videoname";


		 TypedQuery<Video> query= enma.createQuery(jpql, Video.class);


		 query.setParameter("Videoname", "%" + videoname + "%");


		 return query.getResultList();


		 }


		 @Override


		 public List<Video> findAll(int page, int pagesize) {


		 EntityManager enma = JPAConfig.getEntityManager();


		 TypedQuery<Video> query= enma.createNamedQuery("Video.findAll", Video.class);


		 query.setFirstResult(page*pagesize);


		 query.setMaxResults(pagesize);


		 return query.getResultList();


		 }


		 @Override


		 public int count() {


		 EntityManager enma = JPAConfig.getEntityManager();


		 String jpql = "SELECT count(c) FROM Video c";


		 Query query = enma.createQuery(jpql);


		 return ((Long)query.getSingleResult()).intValue();


		 }


	

		}







	


		

