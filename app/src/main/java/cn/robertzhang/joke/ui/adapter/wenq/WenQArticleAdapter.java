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
public class WenQArticleAdapter extends RecyclerView.Adapter<WenQArticleAdapter.ViewHolder> {

    private List<Article> mArticle;

    public WenQArticleAdapter(List<Article> artcleList) {
        mArticle = artcleList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_wenq_article, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textArticleDate.setText(TimeUtil.getEngDate(mArticle.get(position).getStrContMarketTime()));
        holder.textArticleTitle.setText(mArticle.get(position).getStrContTitle());
        holder.textArticleAuthor.setText(mArticle.get(position).getStrContAuthor());
        holder.textArticleContent.setText(Html.fromHtml(mArticle.get(position).getStrContent()));
        holder.textArticleEditor.setText(mArticle.get(position).getStrContAuthorIntroduce());
        holder.textArticleAuthorAddition.setText(mArticle.get(position).getStrContAuthor());
        holder.textArticleAuthorWeibo.setText(mArticle.get(position).getSWbN());
        holder.textArticleAuthorIntro.setText(mArticle.get(position).getSAuth());
    }


    @Override
    public int getItemCount() {
        return mArticle.size();
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

        @Nullable
        @Bind(R.id.article_content) LinearLayout articleContent;

        public ViewHolder(View item) {
            super(item);
            ButterKnife.bind(this, item);
        }
    }
}
