package dataservice.InstituteDataService;

import java.io.File;
import java.io.IOException;

import po.InstitutePO;

public interface InstituteDataService {

	public void init();
	public void insert(InstitutePO po);
	public InstitutePO find(long id);
	public void delete(long id);
	public InstitutePO findlast();
	public String readLastLine(File file, String charset) throws IOException;
}
