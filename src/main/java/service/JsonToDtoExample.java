package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.MyDto;

public class JsonToDtoExample {

    public List<MyDto> readJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = JsonToDtoExample.class.getResourceAsStream("/data.json");
        List<MyDto> filteredList = null; // 修正: filteredListをtryブロックの外で宣言

        try {
            // JSONファイルをリストに読み込む
            List<MyDto> dtoList = objectMapper.readValue(inputStream, new TypeReference<List<MyDto>>() {
            });

            filteredList = dtoList.stream()
                    .filter(dto -> dto.getAge() > 18) // 年齢が18歳以上のDTOのみをフィルタリング
                    .peek(dto -> System.out.println("Filtered DTO: " + dto)) // 途中経過を出力
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return filteredList;
    }
}