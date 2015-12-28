package serverUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileVisitorUtil {
	public static List<String> getList(String path) throws IOException {

		Path startingDir = Paths.get(path);

		FindFileVisitor findJavaVisitor = new FindFileVisitor(".txt");

		Files.walkFileTree(startingDir, findJavaVisitor);

		return findJavaVisitor.getFilenameList();
	}

	public static void nioTransferCopy(File source, File target) {
		FileChannel in = null;
		FileChannel out = null;
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		try {
			inStream = new FileInputStream(source);
			outStream = new FileOutputStream(target);
			in = inStream.getChannel();
			out = outStream.getChannel();
			in.transferTo(0, in.size(), out);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
				in.close();
				outStream.close();
				out.close();
				System.out.println("复制成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
