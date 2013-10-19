package net.ichigotake.colorfulsweetssample;

import java.util.List;

import net.ichigotake.colorfulsweets.lib.menu.MenuItem;
import net.ichigotake.colorfulsweets.lib.menu.MenuListAdapter;
import net.ichigotake.colorfulsweets.lib.menu.SimpleMenuListFactory;
import net.ichigotake.colorfulsweetssample.menu.SimpleMenuSample;
import net.ichigotake.colorfulsweetssample.menu.SimpleMenuSample.SimpleMenuSampleOnClickListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class SimpleMenuSampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		
		SimpleMenuListFactory menuFactory =
				new SimpleMenuListFactory(SimpleMenuSample.values(), new SimpleMenuSampleOnClickListener(this));
		
		ListView menuListView = (ListView) findViewById(R.id.menuList);
		List<MenuItem> menus = menuFactory.create();
		MenuListAdapter adapter = new MenuListAdapter(this, menus);
		menuListView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}

}
