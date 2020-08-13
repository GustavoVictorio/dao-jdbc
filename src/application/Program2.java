package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();

		System.out.println("==== TEST 1: Department findById ====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println("\n==== TEST 2: Department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("\n==== TEST 3: Department Insert ====");
		Department newDep = new Department(null, "Music");
		departmentDao.insert(newDep);
		System.out.println("Inserted! new id: " + newDep.getId());
		
		System.out.println("\n==== TEST 4: Department Update ====");
		Department dep2 = departmentDao.findById(4);
		dep2.setName("Games");
		departmentDao.update(dep2);
		System.out.println("Update completed");

		System.out.println("\n==== TEST 5: Department Delete ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
