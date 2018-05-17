package com.wyc;

import com.wyc.entity.User;
import com.wyc.mapper.TableMapperCustom;
import com.wyc.service.TableService;
import com.wyc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private TableService tableService;

	@Autowired
	private TableMapperCustom tableMapperCustom;

	@Test
	public void contextLoads() {
//		tableMapperCustom.insertData("CompanyName, NumberType, PlateNum, IllegalDate, IllegalPlace, IllegalDetail, Money, Status, lng, lat", "数空,dd, ss, ff, fg, gfh, sds, sdsa, fgg, lkl", "muck_vehicle_illegal");
	}

}
