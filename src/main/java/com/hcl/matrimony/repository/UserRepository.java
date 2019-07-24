package com.hcl.matrimony.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserNameAndPassword(String userName,String password);
	
	@Query(value="select * from user where age>=:ageFrom and age<=:ageTo and gender!=:gender" ,nativeQuery=true)
	List<User> searchUser(@Param("ageFrom") int ageFrom,@Param("ageTo") int ageTo ,@Param("gender")String gender);
	
	@Query(value="select * from user where age>=:ageFrom and age<=:ageTo and gender!=:gender and community=:community", nativeQuery=true)
	List<User> searchUserByCommunity(@Param("ageFrom") int ageFrom,@Param("ageTo") int ageTo ,@Param("gender")String gender,@Param("community")String community);

	@Query(value="select * from user where age>=:ageFrom and age<=:ageTo and gender!=:gender and community=:community and income>=:income",nativeQuery=true)
	List<User> searchUserByCommunityAndIncome(@Param("ageFrom") int ageFrom,@Param("ageTo") int ageTo ,@Param("gender")String gender, @Param("community")String community, @Param("income")long income);

	
	@Query(value="select * from user where age>=:ageFrom and age<=:ageTo and gender!=:gender and community=:community and income>=:income"
			+ " and qualification=:qualification" , nativeQuery=true)
	List<User> searchUserByCommunityIncomeAndQualification(@Param("ageFrom") int ageFrom,@Param("ageTo") int ageTo ,@Param("gender")String gender, @Param("community")String community,
			@Param("income")long income, @Param("qualification")String qualification);
    
	@Query(value="select * from user where age>=:ageFrom and age<=:ageTo and gender!=:gender and community=:community and income>=:income"
			+ " and qualification=:qualification and address=:workLocation",nativeQuery=true)
	List<User> searchUserByAllParameters(@Param("ageFrom") int ageFrom,@Param("ageTo") int ageTo ,@Param("gender")String gender, @Param("community")String community, @Param("income")long income,
			@Param("qualification")String qualification, @Param("workLocation")String workLocation);

}
