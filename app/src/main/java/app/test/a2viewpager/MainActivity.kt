package app.test.a2viewpager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(fragmentOne(), "One")
        adapter.addFragment(fragmentTwo(), "Two")
        adapter.addFragment(fragmenThree(), "Three")
        adapter.addFragment(fragmentFour(), "Four")

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        viewPager.adapter = adapter

        val tableLayout = findViewById<TabLayout>(R.id.tabs)
        tableLayout.setupWithViewPager(viewPager)

    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

    }
}
