package c1;

public class combination  {
	public int r=0;
	public int[] a=new int [10];
	
  public void comb(int m,int k){
	  int i,j;

	  if (k< 0 || k> m)

	  return ;

	  for ( i = m; i >=k; i--)

	  {

	  a[k] = i;//����һ��������a[k]��

	  if (k > 1)

	  {

	  //������ֽ�ΪRamdonsot(i-1,k-1)�𲽷ֽ⣬�ݹ����

		  comb(i- 1, k- 1);//���ϸ����Ĵ𰸺ܶ������Ǵ�ģ���������Ramdonsot(m-1,k-1)���

	  //�кܶ���ظ�

	  }

	  else

	  {

	  for ( j = a[0]; j >0; j--)//a[0]��û�д�����е�����ֻ����Ϊһ���н����

	  {

	  System.out.print(a[j]);
	  if(j==1)
		  System.out.println(" ");

	  // ֮ǰ����ΪSystem.out.print(a[j]+'t')���ͼ���һ��'t'��ʹ����������

	  }
	  
  }
	  }
  }
  }

