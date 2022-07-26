package fr.fms;

import fr.fms.dao.*;
import fr.fms.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTrainingsApplication implements CommandLineRunner {

	@Autowired
	private TrainingRepository trainingRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TrainingOrderRepository trainingOrderRepository;

	@Autowired
	private DetailsRepository detailsRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiTrainingsApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{

		Category language = categoryRepository.save(new Category(null,"Language",null));
		Category CMS = categoryRepository.save(new Category(null,"CMS",null));
		Category framework = categoryRepository.save(new Category(null,"Framework",null));

		Training t1 = trainingRepository.save(new Training(null,"Java","Formation Java",100,1,language,null));
		Training t2 = trainingRepository.save(new Training(null,"DotNet","Formation DotNet",200,1,framework,null));
		Training t3 = trainingRepository.save(new Training(null,"PowerBi","Formation PowerBi",300,1,CMS,null));
		Training t4 = trainingRepository.save(new Training(null,"NodeJs","Formation NodeJs",400,1,framework,null));

		Customer tristan = customerRepository.save(new Customer(null,"Tristan","tristan@mail.com", 118218L,"Ondres","ElfamosoTristano",null));

		TrainingOrder myOrder = trainingOrderRepository.save(new TrainingOrder(null,0,tristan,null));

		detailsRepository.save(new Details(null,t1,myOrder));
		detailsRepository.save(new Details(null,t2,myOrder));
		detailsRepository.save(new Details(null,t3,myOrder));
		detailsRepository.save(new Details(null,t4,myOrder));
	}
}
