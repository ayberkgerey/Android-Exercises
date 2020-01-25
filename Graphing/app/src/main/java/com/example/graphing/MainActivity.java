package com.example.graphing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series1 , series2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double x,y;
        x=0;

        GraphView graph = (GraphView) findViewById(R.id.graph);
        series1 = new LineGraphSeries<>();
        series2 = new LineGraphSeries<>();

        int numDataPoints = 250;
        for (int i = 0 ; i < numDataPoints; i++){
          x = x + 0.1;
          y = Math.sin(x);
          double y2 = Math.cos(x);
          series1.appendData(new DataPoint(x,y), true , 60);
          series2.appendData(new DataPoint(x,y2),true,60);
        }
        series1.setColor(Color.RED);
        series2.setColor(Color.BLUE);
        graph.addSeries(series1);
        graph.addSeries(series2);
    }

 /*   public void addGraph(){
        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        graph.addSeries(series);
 }*/

}
