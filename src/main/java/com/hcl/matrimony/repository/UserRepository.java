package com.hcl.matrimony.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserNameAndPassword(String userName,String password);
	
	@Query(value="select * from user where age>=:ageFrom and age<=:ageTo and gender!=:gender" ,nativeQuery=true)
	List<User> searchUser(int ageFrom,int ageTo ,String gender);
	
	@Query(value="select * from user where age>=:ageFrom and age<=:ageTo and gender!=:gender and community=:community", nativeQuery=true)
	List<User> searchUserByCommunity(int ageFrom,int ageTo ,String gender,String community);

	@Query(value="select * from user where age>=:ageFrom and age<=:ageTo and gender!=:gender and community=:community and income==:income",nativeQuery=true)
	List<User> searchUserByCommunityAndIncome(int ageFrom, int ageTo, String gender, String community, long income);

	
	@Query(value="select * from user where age>=:ageFrom and age<=:ageTo and gender!=:gender and community=:community and income==:income"
			+ " and qualification=:qualification" , nativeQuery=true)
	List<User> searchUserByCommunityIncomeAndQualification(int ageFrom, int ageTo, String gender, String community,
			long income, String qualification);
    
	@Query(value="select * from user where age>=:ageFrom and age<=:ageTo and gender!=:gender and community=:community and income==:income"
			+ " and qualification=:qualification and address=:workLocation",nativeQuery=true)
	List<User> searchUserByAllParameters(int ageFrom, int ageTo, String gender, String community, long income,
			String qualification, String workLocation);

}
