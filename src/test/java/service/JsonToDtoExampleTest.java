package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dto.MyDto;

public class JsonToDtoExampleTest {

    @Test
    public void testReadJson() {
        JsonToDtoExample example = new JsonToDtoExample();
        List<MyDto> result = example.readJson();

        // 結果がnullでないことを確認
        assertNotNull(result, "The result should not be null");

        // フィルタリングされたリストのサイズを確認（期待されるサイズに応じて変更）
        assertEquals(8, result.size(), "The filtered list should contain 8 elements");

        // 特定のDTOの内容を確認
        MyDto firstDto = result.get(0);
        assertEquals("Alice", firstDto.getName(), "The name of the first DTO should be Alice");
        assertEquals(30, firstDto.getAge(), "The age of the first DTO should be 30");

        // 全てのDTOが18歳以上であることを確認
        result.forEach(dto -> assertTrue(dto.getAge() > 18, "Each DTO should have age greater than 18"));
    }
}
