package Tester;

import static org.junit.Assert.*;

import org.junit.Test;

import bl.review.ReviewList;
import bl.review.ReviewListItem;
import mockobject.MockStaff;
import util.OrgType;
import util.Permission;
import util.ResultMessage;

public class Review_AddStaff_tester {

	@Test
	public void test() {
		MockStaff staff1=new MockStaff("ha", 1, OrgType.HALL, Permission.HALLCLERK);
		MockStaff staff2=new MockStaff("haha", 2, OrgType.HALL, Permission.HALLCLERK);
		
		ReviewListItem item1=new ReviewListItem(staff1);
		ReviewListItem item2=new ReviewListItem(staff2);
		
		ReviewList reviewList=new ReviewList();
		reviewList.addReviewListItem(item1);
		reviewList.addReviewListItem(item2);
		
		assertEquals(ResultMessage.SUCCESS,reviewList.check());
	}

}
