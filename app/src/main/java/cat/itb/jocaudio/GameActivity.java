package cat.itb.jocaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton image1;
    private ImageButton image2;
    private ImageButton image3;
    private ImageButton image4;
    private Button sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        image1 = findViewById(R.id.image_1);
        image2 = findViewById(R.id.image_2);
        image3 = findViewById(R.id.image_3);
        image4 = findViewById(R.id.image_4);
        sound = findViewById(R.id.sound_button);

        sound.setOnClickListener(this);

        setRandomPic();
    }
    public int randomSound(){
        int batAudio = R.raw.bat;
        int dogAudio = R.raw.dog;
        int catAudio = R.raw.cat;
        int pigeonAudio = R.raw.pigeon;
        int donkeyAudio = R.raw.donkey;
        int maxNum = 5;
        List<Integer> numbers = new ArrayList<Integer>();

        Random random = new Random();

        do {
            int next = random.nextInt(6);
            if (!numbers.contains(next)){
                numbers.add(next);
                if (next == 1){
                    return batAudio;
                }else if (next == 2){
                    return dogAudio;
                }else if (next == 3){
                    return catAudio;
                }else if (next == 4){
                    return donkeyAudio;
                }else if (next == 5){
                    return pigeonAudio;
                }
            }
        }while (numbers.size()< maxNum);
        return dogAudio;
    }
    public void playAudio(){
        MediaPlayer sound = MediaPlayer.create(GameActivity.this, randomSound());
        sound.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sound_button:
                playAudio();
                break;
            case R.id.image_1:
        }
    }
    public void verifier(){

    }
    public int randomPic(){
        int pic1 = R.drawable.bat, pic2 = R.drawable.dog, pic3 = R.drawable.cat, pic4 = R.drawable.donkey, pic5 = R.drawable.pegion;

        int maxNumPic = 10;
        List<Integer> pics = new ArrayList<Integer>();
        Random random = new Random();

        do {
            int next = random.nextInt(11);
            if (!pics.contains(next)){
                pics.add(next);
                if (next == 1){
                    return pic1;
                }else if (next == 2){
                    return pic2;
                }else if (next == 3){
                    return pic3;
                }else if (next == 4){
                    return pic4;
                }else if (next == 5){
                    return pic5;
                }
            }
        }while (pics.size()< maxNumPic);
        return pic1;
    }
    public void setRandomPic(){
        image1.setImageResource(randomPic());
        image2.setImageResource(randomPic());
        image3.setImageResource(randomPic());
        image4.setImageResource(randomPic());
    }
}