package batch;

import java.util.List;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Users;
import repository.UserRepository;


@Component
public class DBWriter implements ItemWriter<Users>{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void write(List<? extends Users> users) throws Exception{
		System.out.println("Data saved for Users : " + users);
		userRepository.saveAll(users);
	}
}


//package batch;
//
//import java.util.List;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import model.Users;
//import repository.UserRepository;
//
//@Component
//public class DBWriter implements ItemWriter<Users> {
//
//    private static final Logger logger = LoggerFactory.getLogger(DBWriter.class);
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public void write(List<? extends Users> users) throws Exception {
//        logger.info("Data saved for Users: {}", users);
//        try {
//            userRepository.saveAll(users);
//        } catch (Exception e) {
//            // Handle or log the exception as needed
//            logger.error("Error saving users to the database", e);
//            throw e; // Re-throw the exception to ensure the transaction is rolled back
//        }
//    }
//}
