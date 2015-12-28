package serverUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileVisitorUtil {
	public static List<String> getList() throws IOException {

		Path startingDir = Paths.get("TxtData/");

		FindFileVisitor findJavaVisitor = new FindFileVisitor(".txt");

		Files.walkFileTree(startingDir, findJavaVisitor);

		return findJavaVisitor.getFilenameList();
	}

	public static void copy(String arg1, String arg2) {
		// TODO Auto-generated method stub

		File file1 = new File(arg1);
		File file2 = new File(arg2);

		if (!file1.exists()) {
			System.out.println("源文件不存在!");
			return;
		}
		InputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file2, true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (fileInputStream != null && fileOutputStream != null) {
			int temp = 0;
			try {
				/**
				 * 边读边写
				 */
				while ((temp = fileInputStream.read()) != -1) {
					fileOutputStream.write(temp);
				}
				System.out.println("复制完成");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("复制失败");
			} finally {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public static void deleteFile(File file) {
		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				File files[] = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					deleteFile(files[i]);
				}
			}
			file.delete();
		} else {
			System.out.println("所删除的文件不存在！" + '\n');
		}
	}

	public static void main(String[] args) throws IOException {
		Path startingDir = Paths.get("TxtData/");

		FindFileVisitor findJavaVisitor = new FindFileVisitor(".txt");

		Files.walkFileTree(startingDir, findJavaVisitor);

		for (String str : findJavaVisitor.getFilenameList()) {
			System.out.println(str);
		}
	}
}

class FindFileVisitor extends SimpleFileVisitor<Path> {

	private List<String> filenameList = new ArrayList<String>();

	private String fileSuffix = null;

	public FindFileVisitor(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

		if (file.toString().endsWith(fileSuffix)) {
			filenameList.add(file.toString());
		}
		return FileVisitResult.CONTINUE;
	}

	public List<String> getFilenameList() {
		return filenameList;
	}

	public void setFilenameList(List<String> filenameList) {
		this.filenameList = filenameList;
	}
}
