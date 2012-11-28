package agricloud



import grails.test.mixin.*
import org.junit.*
import agricloud.Menu
import agricloud.UserGroup

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(MenuGroup)
@Mock([Menu, UserGroup])
class MenuGroupTests {
	void setUp() {
		def menu1 = new Menu(functionId: 'M1')
		menu1.save()
		def menu2 = new Menu(functionId: 'M2')
		menu2.save()
				
		def userGroup1=new UserGroup(userGroupId:'G1')
		userGroup1.save()
		
		def userGroup2=new UserGroup(userGroupId:'G2')
		userGroup2.save()
	}
	
	void testGroupsMenuCreate() {

		MenuGroup menuGroupGood1=new MenuGroup(userGroup:UserGroup.findById(1),menu:Menu.findById(1))
		assertNotNull  menuGroupGood1.save()
		
		MenuGroup menuGroupGood2=new MenuGroup(userGroup:UserGroup.findById(1),menu:Menu.findById(2))
		assertNotNull menuGroupGood2.save()
		
		MenuGroup menuGroupGood3=new MenuGroup(userGroup:UserGroup.findById(2),menu:Menu.findById(1))
		assertNotNull menuGroupGood3.save()
		
		MenuGroup menuGroupBad1=new MenuGroup(userGroup:UserGroup.findById(1),menu:Menu.findById(1))
		assertNull menuGroupBad1.save()
		
		assert MenuGroup.list().size()==3
		
		
	 }
}
