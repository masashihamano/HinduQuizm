package misao.edu.hinduquiz;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;

/**
 * Created by masashihamano on 2018/02/26.
 */

public class BottomNavigationViewHelper {

    @SuppressLint( "RestrictedApi" )
    public static void disableShiftMode(BottomNavigationView view)
    {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt( 0 );
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField( "shiftingMode" );
            shiftingMode.setAccessible( true );
            shiftingMode.setBoolean( menuView,false );
            shiftingMode.setAccessible( false );


            for (int i =0; i<menuView.getChildCount();i++)
            {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt( i );
                item.setShiftingMode( false );
                item.setChecked( item.getItemData().isChecked() );
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
