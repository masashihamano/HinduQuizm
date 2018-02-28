package misao.edu.hinduquiz;

//import android.content.Context;
//import android.os.AsyncTask;
//import android.os.Handler;
//import android.widget.Toast;

/**
 * Created by masashihamano on 2018/02/27.
 */

//public class CustomToast extends AsyncTask<String, Integer, Integer> implements Runnable{
//    private Toast toast = null;
//    private long duration = 1000;
//    private Handler handler = new Handler();


//    public static CustomToast makeText (Context context, int resId, long duration){
//        CustomToast ct = new CustomToast();
//        ct.toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
//        ct.duration = duration;
//        return ct;
//
//    }
//
//    public static CustomToast makeText (Context context, CharSequence text, long duration){
//        CustomToast ct = new CustomToast();
//        ct.toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
//        ct.duration = duration;
//        return ct;
//    }

//    public void show() {
//        if(duration < 2000){
//            for (int i = 0; i < duration - 5000; i += 1000) {
//                handler.postDelayed(this, 1000);
//            }
//            handler.postDelayed(this, duration - 2000);
//        }else{
//            this.execute();
//        }
//    }

//    public void run() {
//        toast.show();
//    }
//
//    @Override
//    protected Integer doInBackground(String... params) {
//        try {
//            Thread.sleep(duration);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//    @Override
//    protected void onPreExecute() {
//        toast.show();
//    }
//    @Override
//    protected void onPostExecute(final Integer i) {
//        toast.cancel();
//    }
//
//}
