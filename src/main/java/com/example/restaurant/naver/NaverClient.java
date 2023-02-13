package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchImageRes;
import com.example.restaurant.naver.dto.SearchLocalReq;
import com.example.restaurant.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {

    @Value("${naver.client.id}") // application.yaml파일의 값을 가져옴.
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverClientSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;

    // 장소 검색
    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq) {
        // API로 요청 보낼 Uri만들기
        var uri = UriComponentsBuilder.fromUriString(naverLocalSearchUrl)
                .queryParams(searchLocalReq.toMultivalueMap())
                .build()
                .encode()
                .toUri();

        // 헤더 세팅
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 헤더를 담음
        var httpEntity = new HttpEntity<>(headers);

        // 응답받을 타입(res)지정
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};

        // api 값 받아와 responseEntity에 저장
        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();
    }


    public SearchImageRes searchImage(SearchImageReq searchImageReq) {

        // API로 요청 보낼 Uri만들기
        var uri = UriComponentsBuilder.fromUriString(naverImageSearchUrl)
                .queryParams(searchImageReq.toMultivalueMap())
                .build()
                .encode()
                .toUri();

        // 헤더 세팅
        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", naverClientId);
        headers.set("X-Naver-Client-Secret", naverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 헤더를 담음
        var httpEntity = new HttpEntity<>(headers);

        // 응답받을 타입(res)지정
        var responseType = new ParameterizedTypeReference<SearchImageRes>(){};

        // api 값 받아와 responseEntity에 저장
        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();

    }

}






