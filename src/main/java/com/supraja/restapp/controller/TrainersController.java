package com.supraja.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.supraja.restapp.model.Trainers;
import com.supraja.restapp.service.TrainersService;
import com.supraja.restapp.serviceimpl.EmailServiceimpl;

@RestController
@RequestMapping("/trainers")
@CrossOrigin(origins = "http://localhost:3000/")
public class TrainersController {
	@Autowired
	private TrainersService service;
	
	 @Autowired
	  private EmailServiceimpl emailService;
	
	@PostMapping
    public String insertTrainers(
            @RequestParam("trainername") String trainername,
            @RequestParam("trainerEmail") String trainerEmail,
            @RequestParam("phonenumber") String phonenumber,
            @RequestParam("password") String password,
            @RequestParam("age") String age,
            @RequestParam("specialization") String specialization,
            @RequestParam("availability") String availability,
            @RequestParam("certifications") MultipartFile certifications) {

        String msg = "";

        try {
            // Create a Trainer instance and set fields
            Trainers trainer = new Trainers();
            trainer.setTrainername(trainername);
            trainer.setTrainerEmail(trainerEmail);
            trainer.setPhonenumber(phonenumber);
            trainer.setPassword(password);
            trainer.setAge(age);
            trainer.setSpecialization(specialization);
            trainer.setAvailability(availability);
            trainer.setCertifications(certifications.getBytes());

            // Save the trainer using the service
            service.addTrainers(trainer); 
            emailService.sendEmailPassword(trainerEmail, password);

            msg += "addSuccess";
        } catch (Exception e) {
            msg += "addFailure";
            e.printStackTrace(); // or use a logging framework
        }
        return msg;
    }

	@GetMapping("{id}")
	public Trainers getTrainersbyId(@PathVariable("id") int id) {
		return service.getTrainers(id);
	}

	@GetMapping("/all")
	public List<Trainers> getTrainers() {
		return service.getAllTrainers();
	}

	@PutMapping
	public String updateTrainers(@RequestBody Trainers trainers) {
		String msg = "";
		try {
			service.updateTrainers(trainers);
			msg = " Update Success";
		} catch (Exception e) {
			msg = "Failure update";
		}

		return msg;
	}

	@GetMapping("/idlist")
	public List<Integer> getIDList() {
		return service.getAllId();
	}

	@PostMapping("/register")
	public Trainers register(@RequestBody Trainers trainers) {
		return service.addTrainers(trainers);
	}

	 @PostMapping("/login")
	  public Trainers login(@RequestBody Trainers trainers) {
	      Trainers existingTrainers = service.findBytrainerEmail(trainers.getTrainerEmail());

	      if (existingTrainers != null && trainers.getPassword().equals(existingTrainers.getPassword())) {
	          return existingTrainers;
	      } else {
	          return null;
	      }
	  }
	 
	 
	 @GetMapping("/count")
	    public ResponseEntity<Long> getTrainersCount() {
	        long count = service.count();
	        return ResponseEntity.ok(count);
	    }
	 
	 
//	 @PostMapping("/EmailSendToId")
//	  public ResponseEntity<String> rejectCardRequest(
//	          @RequestParam Long id,
//	          @RequestParam String email) {
//	      
//	      // For debugging, log the email
//	      System.out.println("Email received: " + email);
//	      // Handle rejection logic and send email if needed
//	      String userText = String.format(
//		            "Dear Trainer,\\n\\nYour details have been registered by admin.\\n\\nBest regards,\\nYour Company"
//	    		     Your Login Credentials
//		        );
//
//		        String subject = "Card request rejected";
//		        emailService.sendEmail(email, subject, userText);
//
//	      return ResponseEntity.ok("Card request rejected successfully");
//	  }
	 
//	 @PostMapping("/sendLoginCredentials")
//	 public ResponseEntity<String> sendLoginCredentials(
//	         @RequestParam Long trainerId) {
//
//	     // Retrieve trainer details from the database
//	     Trainer trainer = trainerService.findTrainerById(trainerId);
//	     
//	     if (trainer == null) {
//	         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Trainer not found.");
//	     }
//
//	     // Prepare email content
//	     String userText = String.format(
//	             "Dear Trainer,%n%n" +
//	             "Your account has been created successfully. Here are your login credentials:%n%n" +
//	             "Email: %s%n" +
//	             "Password: %s%n%n" +
//	             "Please use these credentials to log in to the trainer portal. If you encounter any issues, please contact support.%n%n" +
//	             "Best regards,%n" +
//	             "Your Company",
//	             trainer.getTrainerEmail(),
//	             trainer.getPassword() // Ensure this is secure; consider hashing passwords and using a reset mechanism
//	     );
//
//	     // Send email
//	     String subject = "Your Trainer Login Credentials";
//	     emailService.sendEmail(trainer.getTrainerEmail(), subject, userText);
//
//	     return ResponseEntity.ok("Login credentials sent successfully.");
//	 }

	 
}
