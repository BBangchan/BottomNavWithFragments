package com.example.bottomnavwithfragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// HomeFragment에서 Fragment를 상속받는다.
class RankingFragment : Fragment() {

    companion object{
        val TAG : String ="로그"

        fun newInstance() : RankingFragment{
            return  RankingFragment()
        }
    }

    //  Fragment가 메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "RankingFragment - onCreate() called()")
    }

    // Fragment를 안고 있는 Activity에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "RankingFragment - onAttach() called()")
    }

    // 뷰가 생성되었을 때 (화면과 서로 연결)
    // Fragment와 layout을 연결시키는 부분이다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        Log.d(TAG, "RankingFragment - onCreateView() called()")

        val view =inflater.inflate(R.layout.fragment_ranking,container,false)

        return view
    }

}