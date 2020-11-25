package ExcelOperation;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.SyncReadListener;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import domain.Question;
import domain.Question_ExcelOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelOperation {
    @Test
    public void read() {
        EasyExcel.read("/Users/willdufresne/Documents/Programming/Source_Codes/Java_Learning_In_Heima/Learn_Java_Framework/Integrated_CaseStudy/test1.xlsx", Question.class, new SyncReadListener(){
            @Override
            public void invoke(Object object, AnalysisContext context) {
                System.out.println(object);
            }
        }).headRowNumber(2).doReadAll();
    }

    @Test
    public void writeWithTemplate() {
        List list = new ArrayList<>();
        list.add(new Question_ExcelOperation("111", "111", "111"));
        list.add(new Question_ExcelOperation("111", "111", "111"));
        list.add(new Question_ExcelOperation("111", "111", "111"));

        EasyExcel.write("/Users/willdufresne/Downloads/test1-w.xlsx", Question_ExcelOperation.class)
                .withTemplate("/Users/willdufresne/Documents/Programming/Source_Codes/Java_Learning_In_Heima/Learn_Java_Framework/Integrated_CaseStudy/question_template.xlsx")
                .sheet().doFill(list);
    }

    @Test
    public void writeWithTemplateFromMultipleSources() {
        ExcelWriterBuilder excelWriterBuilder = EasyExcel.write("/Users/willdufresne/Downloads/test2-w.xlsx", Question_ExcelOperation.class)
                .withTemplate("/Users/willdufresne/Documents/Programming/Source_Codes/Java_Learning_In_Heima/Learn_Java_Framework/Integrated_CaseStudy/question_template.xlsx");

        ExcelWriter excelWriter = excelWriterBuilder.build();

        WriteSheet writeSheet = excelWriterBuilder.sheet().build();

        List list = new ArrayList<>();
        list.add(new Question_ExcelOperation("111", "111", "111"));
        list.add(new Question_ExcelOperation("111", "111", "111"));
        list.add(new Question_ExcelOperation("111", "111", "111"));

        FillConfig fillConfig = FillConfig.builder().forceNewRow(true).build();

        excelWriter.fill(list, fillConfig, writeSheet);

//        Map map = new HashMap<>();

//        map.put("total", 600);

//        excelWriter.fill(new Question_ExcelOperation("222", "2222", "222"), writeSheet);

        excelWriter.finish();
    }
}
