package com.gwhcool.studentcoursems.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.gwhcool.studentcoursems.entity.Course;
import com.gwhcool.studentcoursems.entity.Elective;
import com.gwhcool.studentcoursems.entity.Student;

/**
 * �ļ�������<br>
 * �ṩһЩ�ļ��Ķ�д��������Ҫ�ǽ�obj�����ļ������ļ��е�obj��ȡ����
 * 
 * @author gwh
 * @since 1.0
 *
 */
public class FileUtil {

	/**
	 * ��ѧ��������뵽�ļ���
	 * 
	 * @param student
	 *            Ҫ�����ѧ������
	 */
	public static void ObjToFile(Student student) {
		OutputStream out = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			out = new FileOutputStream(new File(
					"src/com/gwhcool/studentcoursems/datafile/student/Student_" + student.getStuID() + ".obj"));
			objectOutputStream = new ObjectOutputStream(out);
			objectOutputStream.writeObject(student);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ���γ̶�����뵽�ļ���
	 * 
	 * @param course
	 *            Ҫ����Ŀγ̶���
	 */
	public static void ObjToFile(Course course) {
		OutputStream out = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			out = new FileOutputStream(new File(
					"src/com/gwhcool/studentcoursems/datafile/course/Course_" + course.getCourseID() + ".obj"));
			objectOutputStream = new ObjectOutputStream(out);
			objectOutputStream.writeObject(course);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��ѡ�ζ�����뵽�ļ���
	 * 
	 * @param elective
	 *            Ҫ�����ѡ�ζ���
	 */
	public static void ObjToFile(Elective elective) {
		OutputStream out = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			out = new FileOutputStream(new File("src/com/gwhcool/studentcoursems/datafile/elective/Elective_"
					+ elective.getCourseID() + "_" + elective.getStuID() + ".obj"));
			objectOutputStream = new ObjectOutputStream(out);
			objectOutputStream.writeObject(elective);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ���ļ��е�ѧ�������ȡ��ArrayList�б���
	 * 
	 * @return ѧ�������list
	 */
	public static List<Student> fileToStudentObj() {
		List<Student> list = new ArrayList<>();
		Student stu = null;
		InputStream in = null;
		File file = new File("src/com/gwhcool/studentcoursems/datafile/student");
		ObjectInputStream objectInputStream = null;
		try {
			File[] objfiles = file.listFiles();
			for (File f : objfiles) {
				in = new FileInputStream(f);
				objectInputStream = new ObjectInputStream(in);
				stu = (Student) objectInputStream.readObject();
				list.add(stu);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * ���ļ��еĿγ̶����ȡ��ArrayList�б���
	 * 
	 * @return �γ̶����list
	 */
	public static List<Course> fileToCourseObj() {
		List<Course> list = new ArrayList<>();
		Course course = null;
		InputStream in = null;
		File file = new File("src/com/gwhcool/studentcoursems/datafile/course");
		ObjectInputStream objectInputStream = null;
		try {
			File[] objfiles = file.listFiles();
			for (File f : objfiles) {
				in = new FileInputStream(f);
				objectInputStream = new ObjectInputStream(in);
				course = (Course) objectInputStream.readObject();
				list.add(course);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * ���ļ��е�ѡ�ζ����ȡ��ArrayList�б���
	 * 
	 * @return ѡ�ζ����list
	 */
	public static List<Elective> fileToElectiveObj() {
		List<Elective> list = new ArrayList<>();
		Elective elective = null;
		InputStream in = null;
		File file = new File("src/com/gwhcool/studentcoursems/datafile/elective");
		ObjectInputStream objectInputStream = null;
		try {
			File[] objfiles = file.listFiles();
			for (File f : objfiles) {
				in = new FileInputStream(f);
				objectInputStream = new ObjectInputStream(in);
				elective = (Elective) objectInputStream.readObject();
				list.add(elective);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				objectInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * ɾ��ָ���γ̶����ļ��Լ�ѡ�ζ����ļ�
	 * 
	 * @param course
	 *            Ҫɾ���Ŀγ̶���
	 */
	public static void deleteObjFile(Course course) {
		String deleteID = course.getCourseID();
		// ɾ���γ̶����ļ�
		File f = new File("src/com/gwhcool/studentcoursems/datafile/course/Course_" + deleteID + ".obj");
		System.out.println(f.exists());
		System.out.println(f.getName());
		System.out.println(f.getAbsolutePath());

		boolean b = f.delete();
		System.out.println(b);
		// ɾ��ѡ�ζ����ļ�
		File eleDir = new File("src/com/gwhcool/studentcoursems/datafile/elective");
		File[] files = eleDir.listFiles();
		for (File file : files) {
			if (file.getName().contains(deleteID)) {
				System.out.println(file.getName());
				file.delete();
			}
		}
	}

}
