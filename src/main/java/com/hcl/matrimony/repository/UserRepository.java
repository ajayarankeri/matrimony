package com.hcl.matrimony.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserNameAndPassword(String userName,String password);
	
	@Query(value="select * from user where age>=:age_from and age<=:age_to and gender!=:gender")
	List<User> searchUser(int age_from,int age_to ,String gender);
	
	@Query(value="select * from user where age>=:age_from and age<=:age_to and gender!=:gender and community=:community")
	List<User> searchUserByCommunity(int age_from,int age_to ,String gender,String community);

	@Query(value="select * from user where age>=:age_from and age<=:age_to and gender!=:gender and community=:community and income==:income")
	List<User> searchUserByCommunityAndIncome(int age_from, int age_to, String gender, String community, long income);

	
	@Query(value="select * from user where age>=:age_from and age<=:age_to and gender!=:gender and community=:community and income==:income"
			+ "and qualification=:qualification")
	List<User> searchUserByCommunityIncomeAndQualification(int age_from, int age_to, String gender, String community,
			long income, String qualification);
    
	@Query(value="select * from user where age>=:age_from and age<=:age_to and gender!=:gender and community=:community and income==:income"
			+ "and qualification=:qualification and workLocation=:workLocation")
	List<User> searchUserByAllParameters(int age_from, int age_to, String gender, String community, long income,
			String qualification, String workLocation);

}
