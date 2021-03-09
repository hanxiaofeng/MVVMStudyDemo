package com.xinshiyun.mvvmstudydemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.xinshiyun.mvvmstudydemo.adapter.MutilItemAdapter
import com.xinshiyun.mvvmstudydemo.databinding.ActivityRecyclerBinding
import com.xinshiyun.mvvmstudydemo.inner.IBaseBindingAdapterItem
import com.xinshiyun.mvvmstudydemo.model.FruitItem
import com.xinshiyun.mvvmstudydemo.model.TextItem
import kotlinx.android.synthetic.main.activity_recycler.*


class RecyclerActivity : AppCompatActivity() {

    private lateinit var activityRecyclerBinding: ActivityRecyclerBinding

    private val mList = mutableListOf<IBaseBindingAdapterItem>()//数据源

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        activityRecyclerBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);

        initData()

        val adapter = MutilItemAdapter(this@RecyclerActivity, mList)
        val linearLayoutManager =
            LinearLayoutManager(this@RecyclerActivity, OrientationHelper.VERTICAL, false)
        recycler.layoutManager = linearLayoutManager
        recycler.adapter = adapter

        button.setOnClickListener {
            changeData();
        }
    }

    private fun changeData() {
        for (item in mList.withIndex()){
            if(item.value is FruitItem){
                (item.value as FruitItem).url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fm.tuniucdn.com%2Ffb2%2Ft1%2FG2%2FM00%2F2A%2F1B%2FCii-TFekQhqIRiYCAADyVR9i2A4AAAy4wM5iHsAAPJt145_w500_h280_c1_t0.jpg&refer=http%3A%2F%2Fm.tuniucdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616831478&t=50c36369a4fe4c487db6aa10724f998b"
                mList[item.index] = item.value
            }
        }
    }

    private fun initData() {

        mList.add(TextItem("标题1"))
        mList.add(FruitItem("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2574324515,2446667376&fm=26&gp=0.jpg", "苹果"))
        mList.add(FruitItem("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2904989259,3650743495&fm=26&gp=0.jpg", "香蕉"))
        mList.add(TextItem("标题2"))
        mList.add(TextItem("标题3"))
        mList.add(FruitItem("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimage1.nphoto.net%2Fnews%2Fimage%2F201207%2Fb02811c994a40dc8.jpg&refer=http%3A%2F%2Fimage1.nphoto.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616827262&t=48d4e136391e9cfe1be46c393b278b49", "桃子"))
        mList.add(TextItem("标题4"))
        mList.add(FruitItem("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fku.90sjimg.com%2Felement_origin_min_pic%2F00%2F91%2F34%2F3756f166f1d20f6.jpg&refer=http%3A%2F%2Fku.90sjimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616827595&t=c48f5a562338f84597e3f9bc0776cf97", "梨"))
        mList.add(TextItem("标题5"))
        mList.add(TextItem("静静的看书"))
        mList.add(FruitItem("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201609%2F30%2F20160930135859_GRFEk.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616827128&t=e273803ddc3449d9d5f552e17828ecdd", "科举考试"))
        mList.add(TextItem("2方法是"))
        mList.add(FruitItem("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2630899268,2643269677&fm=26&gp=0.jpg", "梨"))
        mList.add(TextItem("大师傅但是"))
    }
}