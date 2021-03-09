package com.xinshiyun.focusdemo

import android.graphics.Paint
import android.os.Bundle
import android.text.TextPaint
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.leanback.widget.*
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.xinshiyun.focusdemo.adapter.ImagePresenter
import com.xinshiyun.focusdemo.adapter.TitlePresenter
import com.xinshiyun.focusdemo.databinding.ActivityHomeBinding
import com.xinshiyun.focusdemo.model.HomeViewModel
import com.xinshiyun.focusdemo.model.ImageModel
import com.xinshiyun.focusdemo.model.TitleModel
import com.xinshiyun.focusdemo.selector.ContentPresenterSelector
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class HomeActivity : AppCompatActivity(), CoroutineScope by MainScope() {


    private lateinit var activityHomeBinding: ActivityHomeBinding
    private lateinit var hvModel: HomeViewModel
    private lateinit var objectAdapter: ArrayObjectAdapter

    private lateinit var mPageAdapter: ArrayObjectAdapter

    private val listDataDefault = mutableListOf<String>(
        "首页",
        "测试",
        "我的",
        "精选案例",
        "前将军",
        "完美",
        "新视云",
        "反思发",
        "互动",
        "调解事业",
        "其他等",
        "hello",
        "你好",
        "数据结束"
    )

    private val listImageDefault = mutableListOf<String>(
        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic.ikafan.com%2Fimgp%2FL3Byb3h5L2h0dHAvaW1hZ2U1OS4zNjBkb2MuY29tL0Rvd25sb2FkSW1nLzIwMTMvMDMvMTMxOS8zMDkxMDgzMF84LmpwZw%3D%3D.jpg&refer=http%3A%2F%2Fpic.ikafan.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617263255&t=047788c1598749b4abd88c31ed484493",
        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.article.pchome.net%2F00%2F34%2F09%2F06%2Fpic_lib%2Fs960x639%2Fjmfj061s960x639.jpg&refer=http%3A%2F%2Fimg.article.pchome.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617263256&t=9f9674b6567cb9e3ab6cf6cc5a3c0069",
        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201804%2F28%2F20180428114906_ulvqd.jpg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617263256&t=ac08a153017ac3be9bcca5a6c808aed3",
        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.article.pchome.net%2F00%2F26%2F57%2F76%2Fpic_lib%2Fs960x639%2Fseaside007s960x639.jpg&refer=http%3A%2F%2Fimg.article.pchome.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617263256&t=379ace6f69f4132c8d331875f6f9164d",
        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.ewebweb.com%2Fuploads%2F20191203%2F19%2F1575371403-OguZIckLNB.jpg&refer=http%3A%2F%2Fimg.ewebweb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617263256&t=71e6f0336707da71f44a10b313b6edf8",
        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.ewebweb.com%2Fuploads%2F20191203%2F19%2F1575371572-HvuyaGrYwq.jpg&refer=http%3A%2F%2Fimg.ewebweb.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1617263256&t=9fa2aa72e54aae0ba4b74d98435b145a"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        hvModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        activityHomeBinding.homeViewModel = hvModel
        initView()

        hvModel.titleList.observe(this, Observer {
            objectAdapter.addAll(0, it)

//            horizontalGridview.requestFocus()
        })

        getData()

        window.decorView.viewTreeObserver.addOnGlobalFocusChangeListener(ViewTreeObserver.OnGlobalFocusChangeListener { oldFocus, newFocus ->
            Log.e("global", "oldFocus = $oldFocus,newFocus = $newFocus")
        })

        btnStart.setOnClickListener {
            Toast.makeText(this@HomeActivity, "click", Toast.LENGTH_LONG).show()
        }

        initGridList()

        addTestData()
    }

    private fun initGridList() {
        verticalGridView.verticalSpacing = 24
        verticalGridView.setTabView(btnStart)

        val presenterSelector = ContentPresenterSelector(this@HomeActivity)
        mPageAdapter = ArrayObjectAdapter(presenterSelector)
        val itemBridgeAdapter = ItemBridgeAdapter(mPageAdapter)
        verticalGridView.adapter = itemBridgeAdapter

    }

    private fun addTestData() {

        val arrayObjectAdapterImage = ArrayObjectAdapter(ImagePresenter(this@HomeActivity))
        val headerItemTen = HeaderItem("图片列表")
        val listRow = ListRow(
            0, headerItemTen,
            arrayObjectAdapterImage
        )
        arrayObjectAdapterImage.addAll(0, getImageData())

        mPageAdapter.add(listRow)

        val arrayObjectAdapterTitle = ArrayObjectAdapter(TitlePresenter())
        val headerItemTitle = HeaderItem("我是标题")
        val listTitleRow = ListRow(
            0, headerItemTitle,
            arrayObjectAdapterTitle
        )
        arrayObjectAdapterTitle.addAll(0, getTitleData())
        mPageAdapter.add(listTitleRow)
        mPageAdapter.add(listRow)
        mPageAdapter.add(listRow)
        mPageAdapter.add(listRow)
        mPageAdapter.add(listRow)
    }

    fun getImageData(): ArrayList<ImageModel> {

        val arrylistData = ArrayList<ImageModel>()
        for (item in listImageDefault) {
            val titleModel = ImageModel(item)
            arrylistData.add(titleModel)
        }
        return arrylistData
    }

    private var mOldTitle: TextView? = null

    private fun initView() {

        horizontalGridview.horizontalSpacing = 20
        objectAdapter = ArrayObjectAdapter(TitlePresenter())
        val itemBridgeAdapter = ItemBridgeAdapter(objectAdapter)
        horizontalGridview.adapter = itemBridgeAdapter

        horizontalGridview.addOnChildViewHolderSelectedListener(object :
            OnChildViewHolderSelectedListener() {

            override fun onChildViewHolderSelected(
                parent: RecyclerView?,
                child: RecyclerView.ViewHolder?,
                position: Int,
                subposition: Int
            ) {
                super.onChildViewHolderSelected(parent, child, position, subposition)

                if (child != null) {
                    val currentTitle = child.itemView.findViewById<TextView>(R.id.tv_main_title)

                    if (null != mOldTitle) {
                        mOldTitle!!.setTextColor(resources.getColor(R.color.design_default_color_error))
                        val paint = mOldTitle!!.paint
                        if (paint != null) {
                            paint.isFakeBoldText = false
                            //viewpager切页标题不刷新，调用invalidate刷新
                            mOldTitle!!.invalidate()
                        }
                    }

                    currentTitle!!.setTextColor(resources.getColor(R.color.white))
                    val paint2 = currentTitle.paint
                    paint2.isFakeBoldText = true
                    //viewpager切页标题不刷新，调用invalidate刷新
                    currentTitle.invalidate()
                    mOldTitle = currentTitle
                }

            }
        })

        horizontalGridview.setOnChildLaidOutListener { parent, view, position, id ->
            {
                Log.e("listener", "parent = $parent,view = $view, position = $position, id = $id")
            }
        }
    }

    fun getTitleData(): ArrayList<TitleModel> {

        val arrylistData = ArrayList<TitleModel>()
        for (item in listDataDefault) {
            val titleModel = TitleModel(item)
            arrylistData.add(titleModel)
        }
        return arrylistData
    }

    fun getData(): MutableLiveData<ArrayList<TitleModel>> {

        val arrylistData = ArrayList<TitleModel>()
        for (item in listDataDefault) {
            val titleModel = TitleModel(item)
            arrylistData.add(titleModel)
        }

        val listData = MutableLiveData<ArrayList<TitleModel>>()

        hvModel.titleList.postValue(arrylistData)
        activityHomeBinding.homeViewModel = hvModel

        return listData
    }
}