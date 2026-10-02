import type * as React from 'react';

/** Nombre de un ícono del kit (135): `Icon.names` los lista todos. */
export type IconName = string;
type Children = { children?: React.ReactNode };
type Option = [string | number, string] | { value: string | number; label: string };

// Marca
/** Categoría de actividad (doc 23) o familia de color de la casa. */
export type Category = 'moverme' | 'leer' | 'crear' | 'aprender' | 'cuidar' | 'compartir';
export type Family = 'mostaza' | 'arcilla' | 'salvia' | 'terracota' | 'ciruela' | 'pizarra';
export interface WordmarkProps { size?: number; tone?: 'ink' | 'paper' | 'white' | 'on-blue' | 'mono'; renglon?: Category | Family | string; compact?: boolean; line?: boolean; className?: string; style?: React.CSSProperties }
export declare function Wordmark(props: WordmarkProps): React.ReactElement;
export interface SymbolProps { size?: number; tone?: WordmarkProps['tone']; renglon?: Category | Family | string; label?: string; className?: string; style?: React.CSSProperties }
export declare function Symbol(props: SymbolProps): React.ReactElement;
export interface AppIconProps { size?: number; variant?: 'azul' | 'tinta' | 'papel'; round?: boolean; label?: string; className?: string }
export declare function AppIcon(props: AppIconProps): React.ReactElement;
export interface ActivityTagProps { category: Category; label?: string; icon?: IconName; className?: string }
export declare function ActivityTag(props: ActivityTagProps): React.ReactElement;
export interface SubrayadoProps extends Children { tone?: 'blue' | 'on-blue' | 'ink'; className?: string }
export declare function Subrayado(props: SubrayadoProps): React.ReactElement;
export interface IconProps { name: IconName; size?: number; strokeWidth?: number; color?: string; mono?: boolean; label?: string; className?: string; style?: React.CSSProperties }
export declare function Icon(props: IconProps): React.ReactElement | null;
export interface TramaProps { mode?: 'campo' | 'senal' | 'foto' | 'icono'; src?: string; icon?: IconName; grid?: 12 | 16; pitch?: number; seed?: number; animate?: boolean; color?: Category | Family; background?: string; label?: string; className?: string; style?: React.CSSProperties }
export declare function Trama(props: TramaProps): React.ReactElement;
export interface TimeDotsProps { value: number; total: number; caption?: boolean; dense?: boolean; className?: string }
export declare function TimeDots(props: TimeDotsProps): React.ReactElement;

// Acciones
export interface ButtonProps extends Children { kind?: 'primary' | 'secondary' | 'destructive'; compact?: boolean; icon?: IconName; disabled?: boolean; muted?: boolean; label?: string; type?: 'button' | 'submit'; onClick?: (e: React.MouseEvent) => void; className?: string; style?: React.CSSProperties }
export declare function Button(props: ButtonProps): React.ReactElement;
export interface GuardedButtonProps extends Children { missing: string | null; kind?: ButtonProps['kind']; icon?: IconName; label?: string; onClick?: (e: React.MouseEvent) => void; onMissing?: (missing: string) => void; className?: string }
export declare function GuardedButton(props: GuardedButtonProps): React.ReactElement;
export interface MissingHintProps extends Children { text?: string; className?: string }
export declare function MissingHint(props: MissingHintProps): React.ReactElement;
export interface PlainActionProps extends Children { label?: string; icon?: IconName; color?: string; disabled?: boolean; onClick?: () => void; className?: string; style?: React.CSSProperties }
export declare function PlainAction(props: PlainActionProps): React.ReactElement;
export interface IconActionProps { icon: IconName; label: string; filled?: boolean; onClick?: () => void; className?: string }
export declare function IconAction(props: IconActionProps): React.ReactElement;
export interface GlassIconButtonProps { icon: IconName; label: string; size?: number; onClick?: () => void; className?: string }
export declare function GlassIconButton(props: GlassIconButtonProps): React.ReactElement;
export interface GlassTextButtonProps extends Children { label?: string; icon?: IconName; color?: string; onClick?: () => void; className?: string }
export declare function GlassTextButton(props: GlassTextButtonProps): React.ReactElement;

// Selección
export interface SegmentedControlProps { options: Option[]; value: string | number | null; onChange?: (value: any) => void; allowDeselect?: boolean; label?: string; className?: string }
export declare function SegmentedControl(props: SegmentedControlProps): React.ReactElement;
export interface ScaleControlProps { value: number | null; onChange?: (value: number | null) => void; low?: string; high?: string; label?: string; className?: string }
export declare function ScaleControl(props: ScaleControlProps): React.ReactElement;
export interface QuickChoiceProps extends Children { label?: string; selected?: boolean; icon?: IconName; onClick?: () => void; className?: string }
export declare function QuickChoice(props: QuickChoiceProps): React.ReactElement;
export interface CheckMarkProps { checked: boolean; size?: number; className?: string }
export declare function CheckMark(props: CheckMarkProps): React.ReactElement;
export interface RadioMarkProps { selected: boolean; className?: string }
export declare function RadioMark(props: RadioMarkProps): React.ReactElement;
export interface StarRatingProps { value: number | null; onChange?: (value: number | null) => void; label?: string; className?: string }
export declare function StarRating(props: StarRatingProps): React.ReactElement;
export interface DurationStepperProps { seconds: number; onChange?: (seconds: number) => void; label: string; className?: string }
export declare function DurationStepper(props: DurationStepperProps): React.ReactElement;
export interface CountStepperProps { value: number; min?: number; max?: number; onChange?: (value: number) => void; label: string; className?: string }
export declare function CountStepper(props: CountStepperProps): React.ReactElement;

// Campos
export interface RenglonFieldProps { label: string; category?: Category; value?: string; defaultValue?: string; onChange?: (value: string) => void; placeholder?: string; multiline?: boolean; maxLength?: number; onKeyDown?: (e: React.KeyboardEvent) => void; className?: string }
export declare function RenglonField(props: RenglonFieldProps): React.ReactElement;
export declare function RenglonArea(props: RenglonFieldProps): React.ReactElement;
export interface SearchFieldProps { placeholder: string; value?: string; defaultValue?: string; onChange?: (value: string) => void; className?: string }
export declare function SearchField(props: SearchFieldProps): React.ReactElement;
export interface SignatureProps { words: string; variant?: 'card' | 'title' | 'signal' | 'sans'; category?: Category | Family | string; prefix?: string; animate?: boolean; as?: string; className?: string }
export declare function Signature(props: SignatureProps): React.ReactElement;

// Listas
export interface ListSectionProps extends Children { title?: string; footer?: string; className?: string }
export declare function ListSection(props: ListSectionProps): React.ReactElement;
export interface ListRowProps { title: React.ReactNode; subtitle?: React.ReactNode; icon?: IconName; iconTint?: string; leading?: React.ReactNode; value?: React.ReactNode; valueIsVoice?: boolean; titleColor?: string; trailing?: React.ReactNode; chevron?: boolean; onClick?: () => void; className?: string }
export declare function ListRow(props: ListRowProps): React.ReactElement;
export interface FactRowProps { icon: IconName; label: string; value: React.ReactNode; valueIsVoice?: boolean; onClick?: () => void; className?: string }
export declare function FactRow(props: FactRowProps): React.ReactElement;
export interface IconTileProps { icon: IconName; tint?: string; className?: string }
export declare function IconTile(props: IconTileProps): React.ReactElement;
export interface NoticeProps extends Children { text?: React.ReactNode; title?: string; icon?: IconName; tone?: 'info' | 'error'; actions?: React.ReactNode; className?: string }
export declare function Notice(props: NoticeProps): React.ReactElement;
export interface StatusChipProps extends Children { text?: string; icon?: IconName; onPanel?: boolean; className?: string }
export declare function StatusChip(props: StatusChipProps): React.ReactElement;
export interface PanelProps extends Children { padding?: number; className?: string; style?: React.CSSProperties }
export declare function Panel(props: PanelProps): React.ReactElement;
export interface SectionHeaderProps { title: string; action?: string; onAction?: () => void; className?: string }
export declare function SectionHeader(props: SectionHeaderProps): React.ReactElement;

// Fotos
interface PictureSource { src?: string; trama?: boolean; category?: Category; icon?: IconName; alt?: string }
export interface PhotoCardProps extends PictureSource { title: string; subtitle?: string; width?: number; onClick?: () => void; className?: string }
export declare function PhotoCard(props: PhotoCardProps): React.ReactElement;
export interface PictureTileProps extends PictureSource { selected: boolean; onClick?: () => void; label?: string; description?: string; aspect?: number; cornerRadius?: number; prominent?: boolean; className?: string }
export declare function PictureTile(props: PictureTileProps): React.ReactElement;
export interface PhotoHeroProps extends PictureSource, Children { aspect?: number; dark?: boolean; onClick?: () => void; clickLabel?: string; className?: string }
export declare function PhotoHero(props: PhotoHeroProps): React.ReactElement;
export interface AvatarProps { size?: number; name?: string; src?: string; emoji?: string; label?: string; background?: string; className?: string }
export declare function Avatar(props: AvatarProps): React.ReactElement;
export interface EmojiTileProps { selected: boolean; onClick?: () => void; label: string; src?: string; emoji?: string; className?: string }
export declare function EmojiTile(props: EmojiTileProps): React.ReactElement;

// Estructura
export interface ScreenProps extends Children { title?: string; eyebrow?: string; subtitle?: string; serif?: boolean; onBack?: () => void; backLabel?: string; closeIcon?: boolean; leading?: React.ReactNode; trailing?: React.ReactNode; progress?: number; step?: string; header?: React.ReactNode; bottom?: React.ReactNode; height?: number | string; className?: string; style?: React.CSSProperties }
export declare function Screen(props: ScreenProps): React.ReactElement;
export interface StepProgressProps { progress: number; step?: string; className?: string }
export declare function StepProgress(props: StepProgressProps): React.ReactElement;
export interface ProgressLineProps { progress: number; label?: string; height?: number; className?: string }
export declare function ProgressLine(props: ProgressLineProps): React.ReactElement;
export interface CarouselProps extends Children { spacing?: number; bleed?: boolean; className?: string }
export declare function Carousel(props: CarouselProps): React.ReactElement;
export interface SheetProps extends Children { open: boolean; onDismiss?: () => void; title?: string; done?: string; tall?: boolean; inline?: boolean }
export declare function Sheet(props: SheetProps): React.ReactElement | null;
export interface TabItem { label: string; icon: IconName; iconSelected?: IconName }
export interface TabBarProps { items: TabItem[]; selected: number; onSelect?: (index: number) => void; className?: string }
export declare function TabBar(props: TabBarProps): React.ReactElement;

export declare function formatDuration(seconds: number): string;

declare global {
  interface Window {
    Relevo: {
      Wordmark: typeof Wordmark; Symbol: typeof Symbol; AppIcon: typeof AppIcon; Subrayado: typeof Subrayado; Icon: typeof Icon & { names: string[] }; Trama: typeof Trama; TimeDots: typeof TimeDots; ActivityTag: typeof ActivityTag;
      Button: typeof Button; GuardedButton: typeof GuardedButton; MissingHint: typeof MissingHint; PlainAction: typeof PlainAction; IconAction: typeof IconAction;
      GlassIconButton: typeof GlassIconButton; GlassTextButton: typeof GlassTextButton;
      SegmentedControl: typeof SegmentedControl; ScaleControl: typeof ScaleControl; QuickChoice: typeof QuickChoice; CheckMark: typeof CheckMark; RadioMark: typeof RadioMark;
      StarRating: typeof StarRating; DurationStepper: typeof DurationStepper; CountStepper: typeof CountStepper;
      RenglonField: typeof RenglonField; RenglonArea: typeof RenglonArea; SearchField: typeof SearchField; Signature: typeof Signature;
      ListSection: typeof ListSection; ListRow: typeof ListRow; FactRow: typeof FactRow; IconTile: typeof IconTile; Notice: typeof Notice; StatusChip: typeof StatusChip;
      Panel: typeof Panel; SectionHeader: typeof SectionHeader;
      PhotoCard: typeof PhotoCard; PictureTile: typeof PictureTile; PhotoHero: typeof PhotoHero; Avatar: typeof Avatar; EmojiTile: typeof EmojiTile;
      Screen: typeof Screen; StepProgress: typeof StepProgress; ProgressLine: typeof ProgressLine; Carousel: typeof Carousel; Sheet: typeof Sheet; TabBar: typeof TabBar;
      formatDuration: typeof formatDuration; CATEGORY: Record<Category, { label: string; icon: IconName }>;
    };
  }
}
