PGDMP     4    )                z           quiz-manager-db    14.4    14.4                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16443    quiz-manager-db    DATABASE     m   CREATE DATABASE "quiz-manager-db" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_India.1252';
 !   DROP DATABASE "quiz-manager-db";
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    3            �            1259    16488    mcq_question    TABLE     U  CREATE TABLE public.mcq_question (
    qid integer NOT NULL,
    qtext character varying(255),
    qtopic character varying(255),
    qdifficulty character varying(255),
    qcorrectanswer character varying(255),
    qwronganswer1 character varying(255),
    qwronganswer2 character varying(255),
    qwronganswer3 character varying(255)
);
     DROP TABLE public.mcq_question;
       public         heap    postgres    false    3            �            1259    16487    mcq_question_qid_seq    SEQUENCE     �   CREATE SEQUENCE public.mcq_question_qid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.mcq_question_qid_seq;
       public          postgres    false    210    3                       0    0    mcq_question_qid_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.mcq_question_qid_seq OWNED BY public.mcq_question.qid;
          public          postgres    false    209            �            1259    16497    open_question    TABLE     �   CREATE TABLE public.open_question (
    qid integer NOT NULL,
    qtext character varying(255),
    qtopic character varying(255),
    qdifficulty character varying(255),
    qtip character varying(255),
    qcorrectanswer character varying(255)
);
 !   DROP TABLE public.open_question;
       public         heap    postgres    false    3            �            1259    16496    open_question_qid_seq    SEQUENCE     �   CREATE SEQUENCE public.open_question_qid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.open_question_qid_seq;
       public          postgres    false    3    212                       0    0    open_question_qid_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.open_question_qid_seq OWNED BY public.open_question.qid;
          public          postgres    false    211            �            1259    16506    student    TABLE        CREATE TABLE public.student (
    id integer NOT NULL,
    name character varying(255),
    password character varying(255)
);
    DROP TABLE public.student;
       public         heap    postgres    false    3            �            1259    16505    student_id_seq    SEQUENCE     �   CREATE SEQUENCE public.student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.student_id_seq;
       public          postgres    false    214    3            	           0    0    student_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.student_id_seq OWNED BY public.student.id;
          public          postgres    false    213            f           2604    16491    mcq_question qid    DEFAULT     t   ALTER TABLE ONLY public.mcq_question ALTER COLUMN qid SET DEFAULT nextval('public.mcq_question_qid_seq'::regclass);
 ?   ALTER TABLE public.mcq_question ALTER COLUMN qid DROP DEFAULT;
       public          postgres    false    209    210    210            g           2604    16500    open_question qid    DEFAULT     v   ALTER TABLE ONLY public.open_question ALTER COLUMN qid SET DEFAULT nextval('public.open_question_qid_seq'::regclass);
 @   ALTER TABLE public.open_question ALTER COLUMN qid DROP DEFAULT;
       public          postgres    false    211    212    212            h           2604    16509 
   student id    DEFAULT     h   ALTER TABLE ONLY public.student ALTER COLUMN id SET DEFAULT nextval('public.student_id_seq'::regclass);
 9   ALTER TABLE public.student ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    213    214    214            �          0    16488    mcq_question 
   TABLE DATA                 public          postgres    false    210   �       �          0    16497    open_question 
   TABLE DATA                 public          postgres    false    212   �       �          0    16506    student 
   TABLE DATA                 public          postgres    false    214   !       
           0    0    mcq_question_qid_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.mcq_question_qid_seq', 27, true);
          public          postgres    false    209                       0    0    open_question_qid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.open_question_qid_seq', 15, true);
          public          postgres    false    211                       0    0    student_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.student_id_seq', 52, true);
          public          postgres    false    213            j           2606    16495    mcq_question mcq_question_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.mcq_question
    ADD CONSTRAINT mcq_question_pkey PRIMARY KEY (qid);
 H   ALTER TABLE ONLY public.mcq_question DROP CONSTRAINT mcq_question_pkey;
       public            postgres    false    210            l           2606    16504     open_question open_question_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.open_question
    ADD CONSTRAINT open_question_pkey PRIMARY KEY (qid);
 J   ALTER TABLE ONLY public.open_question DROP CONSTRAINT open_question_pkey;
       public            postgres    false    212            n           2606    16513    student student_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.student DROP CONSTRAINT student_pkey;
       public            postgres    false    214            �   �  x��U�n�@}�W�Ћ*�MK��JK��J@$�G�����{I��6B�;�kSҴ�e|<q<gΜY_Lg�os��ο�2,$�Uq��&��d4\�/�Of������Fx �A�u	K)4rF��Haa�r�n�5j�BF��p�:�&��&��¦ħ�$�v{�����9Ld�h"KK
A����OJ�R�ay~�yG}��/cpޒ�c=R*x�����ѩ�e�u�6`�~�%05�r��4�1q.�6�f��>��6�Q���
c�L�d��r�旴g�l������N�30K���ҍp�Pݠ�`�%�"��r���E%9�X���e/bx��>dN6�2`T!ˇ�֑�\�%[d�)��~�
�X�Rb���%�y�[�<�痡h���܏�yi(ɀ%�V�N�>|򸟓{�ݵ
�� ��@a���ί@��*�Vt���	N�2#�Cti�ZEu�ם>�P>�o�����|wӫ���gTל�s�=3��9�ƎD�^K!���R��$X�d��q�&�e��Wm�
J��Z·�ڡ��I�����'+j���5Ϸ�x��c�����`�����:X �d����y�?{����^���j]t�����ӱ��p��n����ϐ���!��q*&�.Q��t.�`;8�CS���ms�'ŪIԵO�����SEh�;���8��6�L��� 6$      �   ;  x��TYO�@~�W�P���PQ�R�6R�XM챽�f"��ή��P��'����|��|v_�����.,�(MG��S ���x�x�尗}���-z|K0��I��;r#�B�;O
�v�lC�,�XfqyL��v������d�=����l2�)��+T6��MRqz:
l��D�k6a�q\gV����bm��6T&�ܣ��·0�3�H��Q4N74�ƪ 1~!�����Q��t���y�%BQ�L~�����Q�"-�z��ުd�� *�Z�3j�7�5
��/�K���г 6��#��_\d�����������(r��g����C�&ZůC,���s�/���+t��y����D	��f��C�XІb�=�����x�ڐ��i�K��(ѭp��� ST�\j�L��Z�u���Jx#������(����c�Rc�>MNp���o�Zع��</���Q�jvo�Lϣ�;�21�\�΀
>�R�S�4��ً\2���ײ�
�׆���t�!��6F�{�:<pтV�w��п�؏�vv����Y      �   �  x���K��HF��+��L�Ą��Y��
�(>vT�P򔇨���E���ܱ9YY_�ji��n?Z�{gT�$����M�y3��AwGM�}�U������>���c�g��y�F�_}�n)7�zD!A��ݚ�D4mL�ɋ=vH+�C���s�n�d��v���o�"�rE	K=cT~���,F�M�a��gyQ ���U�W�O$.���{KJ<�6�܅%6�ɸ�v!	���;/���zQc�0�� �E^3qޒ�no�8蠨�0MY��]�V_�֡� 1ݙy������ұ%���s6��;��t�$V�	X��	�YۧN~�~_I�v�X޳�*�*,	�iEE�-���]F��˃qz�C^����:%F�����y�|�y�"��G>렱S�a���̯^@�E��Ka�Sl	�z�󻇉X��o��o���TH�`y0nV���E��h;&��v>�4���Zo�����A��_E~6è�9u;���������6���jaY����>�f��"��*�r�6E�̚�{/�O��3v��`�^�}�C�ف���[�[���gFJY��M���>�)u3�:�3��f���`���'s}�o��s���y�Sh0�y��o������71;�����^b��A>���]!]W�}�%�8���Ew�^[o�e�8���}�,���h�M��Q�9)}�"5��,�v�e�r!_�ͥ[I��a�m󰟴lq���Ų��"��)����y����l��n�`�Q_�&�	��D6(�󚛬'::��#��m\�ɤ5_Xxt?��]�������%�6}�r/���l�W�W���p3�r��#��ː�y0-��Ʈ-N�0kٖ�RQM鮜�k�-��7X���;.s^{vٔ���_�G��     