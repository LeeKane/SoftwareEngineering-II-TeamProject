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

	  a[k] = i;//将第一个数放在a[k]中

	  if (k > 1)

	  {

	  //将问题分解为Ramdonsot(i-1,k-1)逐步分解，递归求和

		  comb(i- 1, k- 1);//网上给出的答案很多这里是错的，给出的是Ramdonsot(m-1,k-1)造成

	  //有很多的重复

	  }

	  else

	  {

	  for ( j = a[0]; j >0; j--)//a[0]并没有存放排列的数，只是做为一个中介的量

	  {

	  System.out.print(a[j]);
	  if(j==1)
		  System.out.println(" ");

	  // 之前在这为System.out.print(a[j]+'t')，就加了一个't'，使结果错得离谱

	  }
	  
  }
	  }
  }
  }

