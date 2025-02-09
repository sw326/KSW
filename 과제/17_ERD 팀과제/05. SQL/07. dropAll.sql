-- 트리거 삭제
DROP TRIGGER TRG_AGE_RATING_ID;
DROP TRIGGER TRG_CATEGORY_ID;
DROP TRIGGER TRG_BOOK_ID;
DROP TRIGGER TRG_MEMBER_ID;
DROP TRIGGER TRG_CHILD_ID;
DROP TRIGGER TRG_ADDRESS_ID;
DROP TRIGGER TRG_DELIVERY_ADDRESS_ID;
DROP TRIGGER TRG_ORDER_ID;
DROP TRIGGER TRG_PAYMENT_ID;
DROP TRIGGER TRG_DELETE_MEMBER;
DROP TRIGGER TRG_SYNC_CART_ITEMS;

-- 테이블 삭제
DROP TABLE "BOOKS" cascade constraint;
DROP TABLE "PAYMENT_METHODS";
DROP TABLE "AGE_RATINGS" cascade constraint;
DROP TABLE "DELIVERY_ADDRESSES" cascade constraint;
DROP TABLE "CHILDREN";
DROP TABLE "CART_ITEMS";
DROP TABLE "ORDERS";
DROP TABLE "CATEGORIES" cascade constraint;
DROP TABLE "ADDRESSES";
DROP TABLE "MEMBER" cascade constraint;
DROP TABLE "MEMBER_TYPE";

-- 시퀀스 삭제
DROP SEQUENCE SEQ_MEMBER_ID;
DROP SEQUENCE SEQ_BOOK_ID;
DROP SEQUENCE SEQ_CHILD_ID;
DROP SEQUENCE SEQ_ORDER_ID;
DROP SEQUENCE SEQ_PAYMENT_ID;
DROP SEQUENCE SEQ_ADDRESS_ID;
DROP SEQUENCE SEQ_DELIVERY_ADDRESS_ID;
DROP SEQUENCE SEQ_CATEGORY_ID;
DROP SEQUENCE SEQ_AGE_RATING_ID;

purge recyclebin;

select tname from tab;
