/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import esprit.entity.Blog;
import esprit.services.BlogServices;
import java.util.Arrays;

import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class BlogStatisticsController implements Initializable {

    @FXML
    private AnchorPane panel;
    @FXML
    private BarChart<String, Integer> barChart;

        private ObservableList<String> monthNames = FXCollections.observableArrayList();
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                String[] months = DateFormatSymbols.getInstance(Locale.FRANCE).getMonths();
                        monthNames.addAll(Arrays.asList(months));
                                xAxis.setCategories(monthNames);
                                
                                  int[] monthCounter = new int[12];
                                BlogServices sc = new BlogServices();
                                  for(Blog b : sc.getAll())
                                  {
                                          int month = b.getDateCreation().getMonthValue() - 1;
                                                      monthCounter[month]++;

                                  }
                                    XYChart.Series<String, Integer> series = new XYChart.Series<>();
                                  
 for (int i = 0; i < monthCounter.length; i++) {
        	series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }
        
        barChart.getData().add(series);


    }    
    
}
