package mockobject;

public class MockIncome {
public long id;
public double income;
public MockIncome(double income,long id)
{
	this.id=id;
	this.income=income;
}
public double getIncome()
{
	return this.income;
}
}

