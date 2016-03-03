package cn.robertzhang.joke.ui.adapter.wenq;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.model.entities.one.Article;
import cn.robertzhang.libraries.utils.LogUtils;
import cn.robertzhang.libraries.utils.TimeUtil;

/**
 * Created by robertzhang on 16/2/18.
 * email: robertzhangsh@gmail.com
 */
public class WenQArticleAdapter extends WenQBaseAdapter<Article> {


    public WenQArticleAdapter(List<Article> mList) {
        super(mList);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.layout_wenq_article;
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        vh.textArticleDate.setText(TimeUtil.getEngDate(mList.get(position).getStrContMarketTime()));
        vh.textArticleTitle.setText(mList.get(position).getStrContTitle());
        vh.textArticleAuthor.setText(mList.get(position).getStrContAuthor());
        vh.textArticleContent.setText(Html.fromHtml(mList.get(position).getStrContent()));
        vh.textArticleEditor.setText(mList.get(position).getStrContAuthorIntroduce());
        vh.textArticleAuthorAddition.setText(mList.get(position).getStrContAuthor());
        vh.textArticleAuthorWeibo.setText(mList.get(position).getSWbN());
        vh.textArticleAuthorIntro.setText(mList.get(position).getSAuth());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        @Bind(R.id.text_article_date) TextView textArticleDate;

        @Nullable
        @Bind(R.id.text_article_title) TextView textArticleTitle;

        @Nullable
        @Bind(R.id.text_article_author) TextView textArticleAuthor;

        @Nullable
        @Bind(R.id.text_article_content) TextView textArticleContent;

        @Nullable
        @Bind(R.id.text_article_editor) TextView textArticleEditor;

        @Nullable
        @Bind(R.id.text_article_author_addition) TextView textArticleAuthorAddition;

        @Nullable
        @Bind(R.id.text_article_author_weibo) TextView textArticleAuthorWeibo;

        @Nullable
        @Bind(R.id.text_article_author_intro) TextView textArticleAuthorIntro;

        public ViewHolder(View item) {
            super(item);
            ButterKnife.bind(this, item);
        }
    }


}
