package com.issue_tracker.app;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.issue_tracker.app.models.Admin;
import com.issue_tracker.app.models.Category;
import com.issue_tracker.app.models.CategoryRep;
import com.issue_tracker.app.models.Issue;
import com.issue_tracker.app.models.User;
import com.issue_tracker.app.services.AdminServices;
import com.issue_tracker.app.services.CategoryRepServices;
import com.issue_tracker.app.services.CategoryServices;
import com.issue_tracker.app.services.IssueServices;
import com.issue_tracker.app.services.UserServices;

@SpringBootTest
@RunWith(SpringRunner.class)
class IssueTrackerApiApplicationTests {
	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	@MockBean
	AdminServices adminService;
	@MockBean
	CategoryServices categoryService;
	@MockBean
	IssueServices issueService;
	@MockBean
	UserServices userService;
	@MockBean
	CategoryRepServices categoryRepService;
	
	//Admin controller test cases
	@Test
	public void getAdminTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		Admin admin=new Admin();
		admin.setAdminId("kisan");
		
		String URL="/api/admin/getAdminPassword";
		String adminJson=objectMapper.writeValueAsString(admin);
		
		Mockito.when(adminService.getPassword(Mockito.anyString())).thenReturn("password");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON_VALUE)
				.content(adminJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		//assertEquals(response.getContentAsString(),"password");
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void getCatagoryListTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/admin/getCategoryList";
		Mockito.when(categoryService.getCategoryList()).thenReturn((ArrayList<String>) Stream.of("harwdware","software").collect(Collectors.toList()));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void addCategoryTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/admin/addCategory";
		Category category=new Category();
		String categoryjson=objectMapper.writeValueAsString(category);
		Mockito.when(categoryService.addCategory(Mockito.any(Category.class))).thenReturn("new category added");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(categoryjson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void getCategoryTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/admin/getCategory";
		
		Mockito.when(categoryService.getCategory()).thenReturn(Stream.of(new Category(),new Category()).collect(Collectors.toList()));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void updateCategoryTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/admin/updateCategory";
		Category category=new Category();
		String categoryJson=objectMapper.writeValueAsString(category);
		Mockito.when(categoryService.updateCatagory(Mockito.any(Category.class))).thenReturn("category updated");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void getCategoryByIdTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/admin/getCategoryById/1";
		Mockito.when(categoryService.getById(Mockito.anyInt())).thenReturn(new Category());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void deleteCategoryTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/admin/deleteCategory/1";
		Mockito.when(categoryService.deleteCategory(Mockito.anyInt())).thenReturn("deleted");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(URL).accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void viewHistoryTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/admin/getIssueHistory";
		Mockito.when(issueService.getAllIssues()).thenReturn(Stream.of(new Issue(),new Issue()).collect(Collectors.toList()));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	//User controller test cases
	@Test
	public void getUserTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/user/getUserPassword";
		User user = new User();
		user.setUsername("kisan");
		String userJson=objectMapper.writeValueAsString(user);
		Mockito.when(userService.getPassword(Mockito.anyString())).thenReturn("password");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(userJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void saveUserDetailsTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/user/saveUser";
		User user = new User();
		user.setUsername("kisan");
		String userJson=objectMapper.writeValueAsString(user);
		
		Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn("user saved");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(userJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(userJson ,response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void saveIssueDetailsTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/user/saveIssue";
		Issue issue=new Issue();
		issue.setIssueCategory("hardware");
		issue.setIssueStatus("new");
		String issueJson=objectMapper.writeValueAsString(issue);
		
		Mockito.when(issueService.saveIssue(Mockito.any(Issue.class))).thenReturn("issue saved");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(issueJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(response.getContentAsString(),issueJson);
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void getUsernameByContactTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/user/forgotUserId";
		User user = new User();
		user.setUsername("kisan");
		String userJson=objectMapper.writeValueAsString(user);
		
		Mockito.when(userService.getUserByContact(Mockito.anyLong())).thenReturn(user);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(userJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(userJson,response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void getUserByUsernameTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/user/forgotPassword";
		User user = new User();
		user.setUsername("kisan");
		String userJson=objectMapper.writeValueAsString(user);
		
		Mockito.when(userService.getUserByUsername(Mockito.anyString())).thenReturn(user);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(userJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(userJson,response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void updatePasswordTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/user/updatePassword";
		User user = new User();
		user.setUsername("kisan");
		String userJson=objectMapper.writeValueAsString(user);
		
		Mockito.when(userService.updatePassword(Mockito.any(User.class))).thenReturn("password updated");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(userJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals("password updated",response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void reopenIssueTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/user/reopenIssue";
		Issue issue=new Issue();
		issue.setIssueCategory("hardware");
		issue.setIssueStatus("new");
		String issueJson=objectMapper.writeValueAsString(issue);
		
		Mockito.when(userService.reopenIssue(Mockito.any(Issue.class))).thenReturn("issue reopened");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(issueJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals("issue reopened",response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	//category rep controller test cases
	
	@Test
	public void saveCategoryRepDetailsTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/category/saveCategoryRep";
		CategoryRep categoryRep=new CategoryRep();
		
		String categoryRepJson=objectMapper.writeValueAsString(categoryRep);
		
		Mockito.when(categoryRepService.saveDetails(Mockito.any(CategoryRep.class))).thenReturn("categoryRep saved");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(categoryRepJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals("categoryRep saved",response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void getCategoryRepTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/category/getCategoryRep";
		CategoryRep categoryRep=new CategoryRep();
		categoryRep.setUsername("kisan");
		String categoryRepJson=objectMapper.writeValueAsString(categoryRep);
		
		Mockito.when(categoryRepService.getByUsername(Mockito.anyString())).thenReturn(categoryRep);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(categoryRepJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(categoryRepJson,response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void getIssueByIdTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/category/getIssueById/1";
		Issue issue=new Issue();
		issue.setIssueCategory("hardware");
		issue.setIssueStatus("new");
		String issueJson=objectMapper.writeValueAsString(issue);
		
		
		Mockito.when(issueService.getById(Mockito.anyInt())).thenReturn(issue);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URL).accept(MediaType.APPLICATION_JSON_VALUE);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals(issueJson,response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
	
	@Test
	public void updateIssueTest() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		String URL="/api/category/updateIssue";
		Issue issue=new Issue();
		issue.setIssueCategory("hardware");
		issue.setIssueStatus("new");
		String issueJson=objectMapper.writeValueAsString(issue);	
		Mockito.when(issueService.updateIssue(Mockito.any(Issue.class))).thenReturn("issue updated");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URL).accept(MediaType.APPLICATION_JSON_VALUE).content(issueJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();	
		assertEquals("issue updated",response.getContentAsString());
		assertEquals(HttpStatus.OK.value(), response.getStatus());	
	}
}
