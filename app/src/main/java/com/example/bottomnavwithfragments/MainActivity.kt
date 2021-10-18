package com.example.bottomnavwithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
// implement를 사용해서 쓸 때
class MainActivity : AppCompatActivity(){

// implement를 사용하지 않고 MainActivity에서 변수처럼 선언해서 클릭 리스너를 설정

    // 멤버 변수 설정.
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment
    // private var homeFragment : HomeFragment? = null과 위에 변수 선언은 비슷한 의미이다.

    companion object{
        const val TAG : String ="로그"
    }

    // 화면이 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 레이아웃과 연결
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called()")
        // 위에는 MainActivity에서 implement를 하여서 this라고 사용이 가능한것이다.
        //bottom_nav.setOnNavigationItemSelectedListener(this)
        // implement를 하지 않아서 this를 사용할 수 없고 아래 변수의 이름을 사용해야 한다.
        bottom_nav.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)

        homeFragment = HomeFragment.newInstance()
        // 처음에 들어갈때는 add로 들어가야 한다.
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()
    }

    // MainActivtiy에 implement를 하지 않고 변수처럼 사용해서
    // 바텀내비게이션의 아이템 클릭 리스너 설정 가능
    private val onBottomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{
        when(it.itemId){
            R.id.menu_home -> {
                Log.d(TAG, "MainActivity - 홈 버튼 클릭")
                homeFragment = HomeFragment.newInstance()
                // supportFragmentManager가 Fragment를 관리한다.
                // replace를 사용한 이유는 처음 있는 fragment에서 교체를 해주면 되기 때문
                // 기존의 fragment_frame을 homeFragment로 교체한다.
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
            }
            R.id.menu_ranking -> {
                Log.d(TAG, "MainActivity - 랭킹 버튼 클릭")
                rankingFragment = RankingFragment.newInstance()
                // supportFragmentManager가 Fragment를 관리한다.
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, rankingFragment).commit()
            }
            R.id.menu_profile -> {
                Log.d(TAG, "MainActivity - 프로필 버튼 클릭")
                profileFragment = ProfileFragment.newInstance()
                // supportFragmentManager가 Fragment를 관리한다.
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, profileFragment).commit()
            }
        }
        true
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        Log.d(TAG, "MainActivity - onNavigationItemSelected() called()")
//        // when은 코틀린에서 switch문이다.
//        when(item.itemId){
//            R.id.menu_home -> {
//                Log.d(TAG, "MainActivity - 홈 버튼 클릭")
//            }
//            R.id.menu_ranking -> {
//                Log.d(TAG, "MainActivity - 랭킹 버튼 클릭")
//            }
//            R.id.menu_profile -> {
//                Log.d(TAG, "MainActivity - 프로필 버튼 클릭")
//            }
//        }
//
//        return true
//    }
}