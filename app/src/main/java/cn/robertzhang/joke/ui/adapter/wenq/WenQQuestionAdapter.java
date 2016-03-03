package cn.robertzhang.joke.ui.adapter.wenq;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.robertzhang.joke.R;
import cn.robertzhang.joke.model.entities.one.Question;
import cn.robertzhang.libraries.utils.TimeUtil;

/**
 * Created by robertzhang on 16/3/3.
 * email: robertzhangsh@gmail.com
 */
public class WenQQuestionAdapter extends WenQBaseAdapter<Question> {

    public WenQQuestionAdapter(List<Question> mList) {
        super(mList);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.layout_wenq_question;
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder)holder;
        vh.textQuestionDate.setText(TimeUtil.getEngDate(mList.get(position).getStrQuestionMarketTime()));
        vh.textQuestionTitle.setText(mList.get(position).getStrQuestionTitle());
        vh.textQuestionContent.setText(Html.fromHtml(mList.get(position).getStrQuestionContent()));
        vh.textAnswerTitle.setText(mList.get(position).getStrAnswerTitle());
        vh.textAnswerContent.setText(Html.fromHtml(mList.get(position).getStrAnswerContent()));
        vh.textAnswerEditor.setText(mList.get(position).getSEditor());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.text_question_date)
        TextView textQuestionDate;
        @Bind(R.id.text_question_title)
        TextView textQuestionTitle;
        @Bind(R.id.text_question_content)
        TextView textQuestionContent;
        @Bind(R.id.text_answer_title)
        TextView textAnswerTitle;
        @Bind(R.id.text_answer_content)
        TextView textAnswerContent;
        @Bind(R.id.text_answer_editor)
        TextView textAnswerEditor;

        public ViewHolder(View item) {
            super(item);
            ButterKnife.bind(this, item);
        }
    }
}
