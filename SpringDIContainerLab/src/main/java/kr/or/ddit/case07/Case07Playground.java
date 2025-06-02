package kr.or.ddit.case07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import kr.or.ddit.case07.conf.Case07ResourceLoadingConfig;
import kr.or.ddit.case07.objs.ResourcesVO;
import lombok.extern.slf4j.Slf4j;

/**	
 * 	스프링을 이용해서 자원을 핸들링하는 방법
 * 	Resource: Spring에서 파일이나 인메모리 자원들을 핸들링할 때 사용되는 추상화 인터페이스
 * 			  다형성의 원리에 따라 모든 구현체의 사용방법은 동일함.
 * 	--모든 Resource는 Wrapper이다. 
 * 	ResourceLoader***: location에 따라 자원을 검색하고, Resource구현체로 생성하여 반환.
 * 	--자원(파일 형태)의 위치와 접근 방법에 따른 분류.
 * 	1. 파일 시스템 자원: D:/00.medias/images/cat4.png, `java.io.File`로 쉽게 객체 생성이 가능.
 * 	2. 클래스 패스 자원: kr/or/ddit/case05/conf/Case05-Context.xml
 * 	3. 웹 자원(url): https://images.pexels.com/photos/9095704/pexels-photo-9095704.jpeg?auto=compress&cs=tinysrgb&w=400
 * 	
 */
@Slf4j
public class Case07Playground {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case07ResourceLoadingConfig.class);
		
		ResourcesVO resVO = context.getBean(ResourcesVO.class);
		
		
//		Resource fileSystemResource = context.getResource("file:D:\\00.medias\\images\\cat4.png");
		Resource fileSystemResource = resVO.getFR();
//		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		printResourceInfo(fileSystemResource);
//		Resource classPathResource = context.getResource("classpath:kr/or/ddit/case05/conf/Case05-Context.xml");
		Resource classPathResource = resVO.getCR();
		printResourceInfo(classPathResource);
//		Resource webResource = context.getResource("http://i.namu.wiki/i/gB4Few9bZ9WRPjM0nN6YKed8fJO4BRnYeWOfhkfjq20dJXc8RHmxudSpRsXgnIRp3hna55IxHqkWjIkMTjblVrgzXdPhDyWDBgGAw7av1VgTGOcr8Bed6ztn5NiENv-iujxEEXXiZ4JmuMItLdZpJQ.webp");
		Resource webResource = resVO.getWR();
		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		printResourceInfo(webResource);
//		Web Resource를 다운로드 받고, d:/ 아래에 다운된 이미지 파일 명으로 저장하기.
//		webResource.g
//		String fileName = fileSystemResource.getFilename();
//		File file = new File("d:/", fileName);
//		WritableResource dest = new FileSystemResource(file);
//		
//		copyResource1(classPathResource, dest);
//		copyResource2(fileSystemResource, dest);
		
		String fileName = fileSystemResource.getFilename();
		File file = new File("d:/", fileName);
		WritableResource dest = new FileSystemResource(file);
		moveResource(fileSystemResource, dest);
		
		
//		try(InputStream in = webResource.getInputStream();
//			FileOutputStream out = new FileOutputStream("d:\\"+webResource.getFilename());	) {
//		
//			//File file = new File("d:/" + webResource.getFilename());
//			byte[] buffer = new byte[4096]; // 4KB 버퍼
//	        int bytesRead;
//	        while((bytesRead = in.read(buffer)) != -1) {
//	            out.write(buffer, 0, bytesRead);
//	        }        
//		} catch(IOException e) {
//			
//		}
	}
	
	private static void moveResource(Resource fileSystemResource, WritableResource dest) throws IOException {
		copyResource2(fileSystemResource, dest);
		deleteResource(fileSystemResource);
	}
	
	private static void deleteResource(Resource fileSystemResource) throws IOException {
		File wrappedFile = fileSystemResource.getFile();
		wrappedFile.delete();
	}
	private static void copyResource2(Resource src, WritableResource dest) {
		try(InputStream in = src.getInputStream();
			OutputStream out = dest.getOutputStream();) {
			
			IOUtils.copy(in,out);
		} catch(IOException e) {}
	}
	
	private static void copyResource1(Resource src, WritableResource dest) throws IOException {
		//원본(src)을 읽고, 그것을 기록(dest)하는 ...
		try(InputStream in = src.getInputStream();
			OutputStream out = dest.getOutputStream();) {	
			
			byte[] buffer = new byte[1024];	//1kb
			int cnt = -1;
			while((cnt = in.read(buffer)) != -1) {	// -1: EOF(End of File) 문자
				out.write(buffer, 0, cnt);
				/*
				 * inputstream으로 buffer라는 byte배열에 데이터를 쪼개서 집어넣음.
				 * 2.5KB 자원이라면,
				 * 1회차(full), 2회차(ful;l), 3회차(절반)만 채워질 것.
				 * 하지만 배열을 비워주는 작업이 없으니까 3회차때 자원이 더러워질 거임.
				 * 0부터 cnt까지만 읽어주세요~~
				 */
			}
			out.flush();
		}
		
	}
	
	private static void printResourceInfo(Resource res) throws IOException {
	log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	log.info("■■■■■■■■■■■■■   Loaded File: {} ^0^", res);
	log.info("■■■■■■■■■■■□■  Size of File: {} >_<", res.contentLength());
	log.info("■■■■■■■■■■■□■ Original Name: {} ^ㅂ^", res.getFilename());
	log.info("■■■■■■■■■■■□■  isFile exist: {} >^<", res.exists());
	log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	
	}
}
