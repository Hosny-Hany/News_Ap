package com.route.news_application.ui.News
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.route.news_application.NewsError
import com.route.news_application.showMessage
import com.route.news_application.repository.SourcesResponse.Source
import com.route.news_application.databinding.FragmentNewsBinding
import javax.inject.Inject

class NewsFragment : Fragment() {
    lateinit var ViewBinding: FragmentNewsBinding
    lateinit var ViewModel : News_ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModel =ViewModelProvider(this)[(News_ViewModel::class.java)]
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ViewBinding = FragmentNewsBinding.inflate(inflater,container,false)
        return ViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialNews()
        ViewModel.getNewsSources()
        initObserves()
    }

    private fun initObserves() {
        ViewModel.shouldShowLoading
            .observe(viewLifecycleOwner,object  :Observer<Boolean>{
                override fun onChanged(value: Boolean) {
                    ViewBinding.progressBar.isVisible = isVisible
                }
            })
        ViewModel.ResorcesLoading.observe(viewLifecycleOwner){Source->
            bindTabs(Source)
        }
        ViewModel.NewsLiveData.observe(viewLifecycleOwner){
            adapter.bindNews(it)
        }
        ViewModel.ErrorLiveData.observe(viewLifecycleOwner){
            HandleError(it)
        }
    }

    @Inject lateinit var adapter : News_Adapter
    private fun initialNews() {
        ViewBinding.NewsRecycler.adapter=adapter
    }

    private fun bindTabs(sources: List<Source?>?) {

                    if (sources == null) return
                    sources?.forEach { source ->
                        val tab = ViewBinding.tabLayout.newTab()
                        tab.text = source?.name
                        tab.tag = source
                        ViewBinding.tabLayout.addTab(tab)
                    }

                    ViewBinding.tabLayout.addOnTabSelectedListener(
                        object : TabLayout.OnTabSelectedListener {
                            override fun onTabSelected(tab: TabLayout.Tab) {
                                val source = tab.tag as Source
                               ViewModel.getNews(source.id)
                            }

                            override fun onTabUnselected(tab: TabLayout.Tab?) {
                            }

                            override fun onTabReselected(tab: TabLayout.Tab?) {
                                val source = tab?.tag as Source
                                ViewModel.getNews(source.id)
                            }
                        }
                    )
                    ViewBinding.tabLayout.getTabAt(0)?.select()

                }


    fun HandleError(NewsError: NewsError){
        showMessage(
            message = NewsError.message?:
            NewsError.throwable?.localizedMessage?:"Something went error",
            posActionName = "TryAgain",
            posAction = { dialogInterface, i ->
                dialogInterface.dismiss()
                NewsError.onTryAgainClickListener?.onTryAgainClick()
            }, negActionName = "Cancle",
            negAction = { dialogInterface, i ->
                dialogInterface.dismiss()

            }
        )

    }

}
