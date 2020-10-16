package com.hillel.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.hillel.jdbc.dao.ItemDao;
import com.hillel.jdbc.dao.KryvorotenkosShopDao;
import com.hillel.jdbc.dao.VitaliyUserDao;
import com.hillel.jdbc.model.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.hillel.jdbc.dao.WarehouseDao;

@ContextConfiguration("classpath:spring-context.xml")
public class TestSimpleJdbc extends AbstractJUnit4SpringContextTests {
	@Autowired
	private WarehouseDao warehouseDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private KryvorotenkosShopDao KryvorotenkosShopDao;
	@Autowired
	private VitaliyUserDao vitaliyUserDao ;

	@Test
	public void testWarehouseCRUD() {
		String testData = "test address";
		// Создать тестовый объект
		Warehouse testWarehouse = new Warehouse();
		testWarehouse.setAddress(testData);
		// Сохранить тестовый объект в базе данных
		warehouseDao.insert(testWarehouse);
		// Вытащить тестовый объект из базы данных
		Warehouse warehouseFromDb = warehouseDao.findById(testWarehouse.getId());
		// Сравнить вытащенный объект из базы данных с тестовым объектом
		assertEquals(testWarehouse.getAddress(), warehouseFromDb.getAddress());

		warehouseFromDb.setAddress("updated address wow");
		warehouseDao.update(warehouseFromDb);

		// Удалить тестовый объект в базе данных
		warehouseDao.delete(warehouseFromDb);
		// Найти удаленный объект в базе данных
		Warehouse removedWarehouse = warehouseDao.findById(warehouseFromDb.getId());
		// Сравнить вытащенный объект после удаления из базы данных на null
		assertNull(removedWarehouse);
	}

	@Test
	public void testItemCRUD() {
		String testData = "test address";
		// Создать тестовый объект
		Item testItem = new Item();
		testItem.setName(testData);
		testItem.setWarehouse_id(1l);
		// Сохранить тестовый объект в базе данных
		itemDao.insert(testItem);
		// Вытащить тестовый объект из базы данных
		Item itemFromDb = itemDao.findById(testItem.getId());
		// Сравнить вытащенный объект из базы данных с тестовым объектом
		assertEquals(testItem.getName(), itemFromDb.getName());

		itemFromDb.setName("updated name wow");
		itemDao.update(itemFromDb);

		// Удалить тестовый объект в базе данных
		itemDao.delete(itemFromDb);
		// Найти удаленный объект в базе данных
		Item removedItem = itemDao.findById(itemFromDb.getId());
		// Сравнить вытащенный объект после удаления из базы данных на null
		assertNull(removedItem);
	}

	@Test
	public void testKryvorotenkosShopCRUD() {
		String testData = "test shop address";
		// Создать тестовый объект
		KryvorotenkosShop testKryvorotenkosShop = new KryvorotenkosShop();
		testKryvorotenkosShop.setAddress(testData);
		// Сохранить тестовый объект в базе данных
		KryvorotenkosShopDao.insert(testKryvorotenkosShop);
		// Вытащить тестовый объект из базы данных
		KryvorotenkosShop kryvorotenkosShopFromDb = KryvorotenkosShopDao.findById(testKryvorotenkosShop.getId());
		// Сравнить вытащенный объект из базы данных с тестовым объектом
		assertEquals(testKryvorotenkosShop.getAddress(), kryvorotenkosShopFromDb.getAddress());

		kryvorotenkosShopFromDb.setAddress("updated address wow");
		KryvorotenkosShopDao.update(kryvorotenkosShopFromDb);

		// Удалить тестовый объект в базе данных
		KryvorotenkosShopDao.delete(kryvorotenkosShopFromDb);
		// Найти удаленный объект в базе данных
		KryvorotenkosShop removedItem = KryvorotenkosShopDao.findById(kryvorotenkosShopFromDb.getId());
		// Сравнить вытащенный объект после удаления из базы данных на null
		assertNull(removedItem);
	}

	@Test
	public void testVitaliyUserVCRUD() {
		String testData = "Sasha";
		// Создать тестовый объект
		VitaliyUser testVitaliyUser = new VitaliyUser();
		testVitaliyUser.setName(testData);
		testVitaliyUser.setStatus(VitaliyStatus.ACTIVE);
		// Сохранить тестовый объект в базе данных
		vitaliyUserDao.insert(testVitaliyUser);
		// Вытащить тестовый объект из базы данных
		VitaliyUser vitaliyUserFromDb = vitaliyUserDao.findById(testVitaliyUser.getId());
		// Сравнить вытащенный объект из базы данных с тестовым объектом
		assertEquals(testVitaliyUser.getName(), vitaliyUserFromDb.getName());

		vitaliyUserFromDb.setName("Kolia");
		vitaliyUserDao.update(vitaliyUserFromDb);

		// Удалить тестовый объект в базе данных
		vitaliyUserDao.delete(vitaliyUserFromDb);
		// Найти удаленный объект в базе данных
		VitaliyUser removedVitaliyUser = vitaliyUserDao.findById(vitaliyUserFromDb.getId());
		// Сравнить вытащенный объект после удаления из базы данных на null
		assertNull(removedVitaliyUser);
	}
}
