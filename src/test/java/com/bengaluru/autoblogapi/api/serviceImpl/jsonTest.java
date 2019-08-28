package com.bengaluru.autoblogapi.api.serviceImpl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class jsonTest {
    @Test
    public void jsonTest(){
        String str = "{\"reponse\":{\"resultCode\":\"1\",\"result\":[{\"contentsKor\":\"&lt;p class='cardTip'&gt;&lt;img src='http://vod.fss.or.kr/vod/fine/tip/118_1.jpg' alt='외국환거래법규상 금융소비자 유의사항(부동산거래 금전대차편)'/&gt;&lt;/p&gt;&lt;p class='cardTip'&gt;&lt;img src='http://vod.fss.or.kr/vod/fine/tip/118_2.j\n" +
                "pg' alt='국내 '거주자'가 해외 부동산거래 금전대차시 유의해야할 사항은 무엇일까요?'/&gt;&lt;/p&gt;&lt;p class='cardTip'&gt;&lt;img src='http://vod.fss.or.kr/vod/fine/tip/118_3.jpg' alt='거주자가 해외부동산을 취득(또는 임차보증금이 1만불 초과)하는 경우, 외국환은행장 앞으로 사전 신고해야 합니다.'/&gt;&lt;/\n" +
                "p&gt;&lt;p class='cardTip'&gt;&lt;img src='http://vod.fss.or.kr/vod/fine/tip/118_4.jpg' alt='해외부동산을 취득할 때뿐만 아니라, 처분할 때에도 외국환은행장 앞으로 처분 후 3개월 이내에 해당 내용을 보고해야 합니다.'/&gt;&lt;/p&gt;&lt;p class='cardTip'&gt;&lt;img src='http://vod.fss.or.kr/vod/fine/tip/118_5\n" +
                ".jpg' alt='거주자가 비거주자로부터 자금을 차입하는 경우, 사전에 구체적인 내용을 밝혀 금전대차 신고를 해야 합니다.'/&gt;&lt;/p&gt;&lt;p class='cardTip'&gt;&lt;img src='http://vod.fss.or.kr/vod/fine/tip/118_6.jpg' alt='거주자가 비거주자에게 자금을 대출하는 경우, 한국은행 총재에게 신고를 해야 합니다.'/&gt;\n" +
                "&lt;/p&gt;&lt;p class='cardTip'&gt;&lt;img src='http://vod.fss.or.kr/vod/fine/tip/118_7.jpg' alt='외화차입 신고는 이미 했는데, 만기를 좀 연장하려고 합니다. 또 신고해야 할까요?'/&gt;&lt;/p&gt;&lt;p class='cardTip'&gt;&lt;img src='http://vod.fss.or.kr/vod/fine/tip/118_8.jpg' alt='해외부동산 취득신고 등 외\n" +
                "국환 거래 관련 각종 신고나 보고 의무를 소홀히 하면 앞서 살펴본 각 사례의 과태료 처분 외에도 여러 제재조치를 받을 수 있으니, 주의하세요!'/&gt;&lt;/p&gt;&lt;p class='cardTip'&gt;&lt;img src='http://vod.fss.or.kr/vod/fine/tip/118_9.jpg' alt='참고'/&gt;&lt;/p&gt;&lt;p class='cardTip'&gt;&lt;img src='http://\n" +
                "vod.fss.or.kr/vod/fine/tip/118_10.jpg' alt='끝.'/&gt;&lt;/p&gt;\",\"publishOrg\":\"금융감독원\",\"regDate\":\"2019-06-07 08:59:04\",\"contentId\":\"118\",\"brmTrans\":\"1\",\"repcategory\":\"금융꿀팁 200선\",\"temp1\":\"은행\",\"brmCode\":\"L01\",\"policyType\":\"G00303\",\"atchfileUrl\":\"http://fine.fss.or.kr/fss.hpdownload?file=190607_\n" +
                "%C1%B6%B0%A3_%BF%DC%B1%B9%C8%AF%B0%C5%B7%A1%B9%FD%B1%D4%BB%F3+%B1%DD%C0%B6%BC%D2%BA%F1%C0%DA+%C0%AF%C0%C7%BB%E7%C7%D7%28%BA%CE%B5%BF%BB%EA%B0%C5%B7%A1-%B1%DD%C0%FC%B4%EB%C2%F7%C6%ED%29.pdf&path=/consumer/tip/|http://fine.fss.or.kr/fss.hpdownload?file=109%C2%F7+%B1%E2%BB%E7_1.jpg&path=/consumer/tip/\",\"or\n" +
                "iginUrl\":\"http://fine.fss.or.kr/main/fin_tip/tip/tip_view.jsp?seqno=118\",\"subject\":\"외국환거래법규상 금융소비자 유의사항(부동산거래·금전대차편)\",\"viewCnt\":\"1036\",\"atchfileNm\":\"190607_조간_외국환거래법규상 금융소비자 유의사항(부동산거래-금전대차편).pdf|109차 기사_1.jpg\",\"lists\":\"\"}],\"resultMsg\":\"조회 성\n" +
                "공\",\"resultCnt\":1}}\n";

        JsonParser Parser = new JsonParser();
        JsonObject jsonObj = (JsonObject) Parser.parse(str);
        JsonObject respObj = jsonObj.getAsJsonObject("reponse");
        System.out.println("CIS >> " + respObj.get("resultCode"));
        System.out.println("CIS >> " + respObj.get("resultCode").toString());
        String resultCode = respObj.get("resultCode").toString();
        System.out.println("resultCode = " + resultCode);
        System.out.println("resultCode = " + resultCode.length());
        if("\"1\"".equals(resultCode)){
            System.out.println("  이것이 ??? ");
        }


        if ("1".equals(respObj.get("resultCode").toString())) {  // API 로 가져온 데이터가 있으면!!!
            JsonArray tipArr = respObj.getAsJsonArray("result");
            System.out.println("tipArr = " + tipArr.toString());
            System.out.println("size = " + tipArr.size());
            for (int i = 0; i < tipArr.size(); i++) {
                JsonObject tipObj = (JsonObject) tipArr.get(i);
                System.out.println("일자 : " + tipObj.get("regDate"));
                System.out.println("제목 : " + tipObj.get("subject"));
                System.out.println("내용 : " + tipObj.get("contentsKor"));
                System.out.println("원본URL : " + tipObj.get("originUrl"));
                System.out.println("------------------------");
            }
        }

    }
}
