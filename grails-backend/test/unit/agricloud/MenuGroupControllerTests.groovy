package agricloud



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(MenuGroupController)
@Mock([MenuGroup,Menu,UserGroup])
class MenuGroupControllerTests {
	
	
	void setUp() {
		new Menu(functionId: 'M1').save(failOnError: true)
		new UserGroup(userGroupId:'G1').save(failOnError: true)

		new Menu(functionId: 'M2').save(failOnError: true)
		new UserGroup(userGroupId:'G2').save(failOnError: true)
				
		new MenuGroup(userGroup:UserGroup.findById(2),menu:Menu.findById(2)).save(failOnError: true)

	}

    void testCreate() {
		println 'testCreate MenuGroup.list='+MenuGroup.list().size()
		request.JSON.menuId='M1'
		request.JSON.userGroupId='G1'
		controller.create()

		assert response.json.success==true
		assert MenuGroup.list().size()==2
		
    }
	void testDelete() {
		println 'testDelete MenuGroup.list='+MenuGroup.list().size()
		params.id=1
		controller.delete()
		
		assert response.json.success==true
		assert MenuGroup.list().size()==0
		
	}

}
