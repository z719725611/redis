package com.microblog.biz.impl;

import com.microblog.biz.BlogBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BlogBizImpl extends BaseBiz implements BlogBiz {

	// 点赞（redis）
	@Override
	public String parse(Long id, int uid) {
		// 当用户没有点赞，则点赞数+1，redis中用户字段+1；点了赞，则点赞数-1，redis中用户字段-1
		if (id > 0 && uid > 0) {
			if (this.baseDao.getKey(id + "user:id" + uid) == null
					|| Integer.parseInt((String) this.baseDao.getKey(id
							+ "user:id" + uid)) == 0) {
				this.baseDao.incr("user:parse" + id);

				this.baseDao.incr(id + "user:id" + uid);
			} else {
				this.baseDao.decr("user:parse" + id);
				this.baseDao.decr(id + "user:id" + uid);
			}
			String num = (String) this.baseDao.getKey("user:parse" + id);
			return num;
		} else {
			return null;
		}

	}

	// 转发（redis）

	@Override
	public String relay(Long id, int uid) {
		// 当用户没有转发，则转发数+1，redis中用户字段+1；已转发，则不允许转发
		if (id > 0 && uid > 0) {
			String num = (String) this.baseDao.getKey("user:relay" + id);
			if (this.baseDao.getKey(id + "user:relayid" + uid) == null
					|| Integer.parseInt((String) this.baseDao.getKey(id
							+ "user:relayid" + uid)) == 0) {
				this.baseDao.incr("user:relay" + id);
				this.baseDao.incr(id + "user:relayid" + uid);
				num = (String) this.baseDao.getKey("user:relay" + id);
				return num;
			} else {
				return num;
			}
		} else {
			return null;
		}
	}



}
